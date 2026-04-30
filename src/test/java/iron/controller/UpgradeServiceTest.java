package iron.controller;

import iron.model.DataManager;
import iron.model.License;
import iron.model.Racer;
import iron.model.RaceResults;
import iron.model.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UpgradeServiceTest {

    @Mock
    private DataManager dataManager;

    private UpgradeService upgradeService;
    private NotificationService notificationService;
    private LicenseService licenseService;
    private Racer validRacer;
    private License validLicense;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        notificationService = new NotificationService(dataManager);
        licenseService = new LicenseService(dataManager);
        upgradeService = new UpgradeService(dataManager, notificationService, licenseService);

        // test dates
        Date issueDate = Date.from(LocalDateTime.of(2026, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));
        Date expirationDate = Date.from(LocalDateTime.of(2027, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));

        validLicense = new License("LIC001", issueDate, expirationDate, 2);
        validRacer = new Racer("RACER001", "John Doe", 2, "PAY123", validLicense, null);
        validRacer.setRaceHistory(new ArrayList<>());
    }

    // eligible racer with 3 podium finishes
    @Test
    @DisplayName("Racer with 3 podium finishes should be eligible for upgrade")
    void testEligibleRacerWithPodiums() {
        // add 3 podium finishes
        Race race = new Race("RACE001", "Test Race", new Date(), 10.0f, 100, true);
        validRacer.getRaceHistory().add(new RaceResults("RES001", race, validRacer, 1, true));
        validRacer.getRaceHistory().add(new RaceResults("RES002", race, validRacer, 2, true));
        validRacer.getRaceHistory().add(new RaceResults("RES003", race, validRacer, 3, true));

        assertTrue(upgradeService.checkUpgradeEligibility(validRacer));
    }

    // racer with less than 3 podiums
    @Test
    @DisplayName("Racer with less than 3 podium finishes should not be eligible")
    void testIneligibleRacerWithFewPodiums() {
        Race race = new Race("RACE001", "Test Race", new Date(), 10.0f, 100, true);
        validRacer.getRaceHistory().add(new RaceResults("RES001", race, validRacer, 1, true));
        validRacer.getRaceHistory().add(new RaceResults("RES002", race, validRacer, 4, false));

        assertFalse(upgradeService.checkUpgradeEligibility(validRacer));
    }

    // expired license
    @Test
    @DisplayName("Racer with expired license should not be eligible")
    void testExpiredLicense() {
        Date pastExpiration = Date.from(LocalDateTime.of(2025, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));
        validLicense.setExpirationDate(pastExpiration);

        Race race = new Race("RACE001", "Test Race", new Date(), 10.0f, 100, true);
        validRacer.getRaceHistory().add(new RaceResults("RES001", race, validRacer, 1, true));
        validRacer.getRaceHistory().add(new RaceResults("RES002", race, validRacer, 2, true));
        validRacer.getRaceHistory().add(new RaceResults("RES003", race, validRacer, 3, true));

        assertFalse(upgradeService.checkUpgradeEligibility(validRacer));
    }

    // null inputs
    @Test
    @DisplayName("Null inputs should be handled gracefully")
    void testNullInputs() {
        assertFalse(upgradeService.checkUpgradeEligibility(null));

        upgradeService.upgradeRacerCategory(null);
        verify(dataManager, never()).updateRecord(anyString(), anyString(), anyString());
    }

    // notification sent after upgrade
    @Test
    @DisplayName("Notification should be sent after upgrade")
    void testNotificationSentAfterUpgrade() {
        doNothing().when(dataManager).updateRecord(anyString(), anyString(), anyString());

        int categoryBefore = validRacer.getCategory();
        upgradeService.upgradeRacerCategory(validRacer);

        // category should decrease by 1
        assertEquals(categoryBefore - 1, validRacer.getCategory());

        // notification should be added to racer
        assertNotNull(validRacer.getNotifications());
        assertEquals(1, validRacer.getNotifications().size());
        assertTrue(validRacer.getNotifications().get(0).getMessage()
                .contains("Congratulations"));
    }
}
