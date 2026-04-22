package iron.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import iron.model.DataManager;
import iron.model.License;
import iron.model.Race;
import iron.model.RaceReg;
import iron.model.Racer;

public class RegistrationServiceTest {

    @Mock
    private DataManager dataManager;

    private RegistrationService registrationService;
    
    private Racer validRacer;
    private Race validRace;
    private License validLicense;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registrationService = new RegistrationService(dataManager);
        
        // test dates
        Date licenseIssueDate = Date.from(LocalDateTime.of(2026, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));
        Date licenseExpirationDate = Date.from(LocalDateTime.of(2027, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));
        Date raceDate = Date.from(LocalDateTime.of(2026, 5, 15, 0, 0).toInstant(ZoneOffset.UTC));
        Date registrationDeadline = Date.from(LocalDateTime.of(2026, 4, 30, 0, 0).toInstant(ZoneOffset.UTC));
        
        // test license
        validLicense = new License("LIC001", licenseIssueDate, licenseExpirationDate, 1);
        
        validRacer = new Racer("RACER001", "John Doe", 1, "PAY123", validLicense, registrationService);
        validRacer.setRegistrations(new ArrayList<>());
        
        validRace = new Race("RACE001", "Test Race", raceDate, 10.0f, 100, true);
        validRace.setRegistrations(new ArrayList<>());
        validRace.setRegistrationDeadline(registrationDeadline);
        
        // allowed categories
        List<Integer> allowedCategories = new ArrayList<>();
        allowedCategories.add(1);
        allowedCategories.add(2);
        validRace.setAllowedCategories(allowedCategories);
    }

    //  successful registration
    @Test
    @DisplayName("Successful registration should return registration ID")
    void testSuccessfulRegistration() {

        doNothing().when(dataManager).updateRecord(anyString(), anyString(), anyString());
        String result = registrationService.signUpForRace(validRacer, validRace);
        
        // assert
        assertNotNull(result);
        assertFalse(result.startsWith("Error:"));
        assertFalse(result.startsWith("Registration is closed"));
        assertFalse(result.startsWith("Invalid"));
        assertFalse(result.startsWith("Your category"));
        assertFalse(result.startsWith("This race is full"));
        
        // Verify data manager was called
        verify(dataManager, times(2)).updateRecord(anyString(), anyString(), anyString());
        
        // Verify registration was added to both race and racer
        assertEquals(1, validRace.getRegistrations().size());
        assertEquals(1, validRacer.getRegistrations().size());
    }

    //  null inputs
    @Test
    @DisplayName("Null inputs should return appropriate errors")
    void testNullInputs() {
        // null racer
        String result1 = registrationService.signUpForRace(null, validRace);
        assertEquals("Error: Racer information is required.", result1);
        
        // null race
        String result2 = registrationService.signUpForRace(validRacer, null);
        assertEquals("Error: Race information is required.", result2);
        
        // null license
        validRacer.setLicense(null);
        String result3 = registrationService.signUpForRace(validRacer, validRace);
        assertEquals("Invalid or expired license. Please renew your license before registering.", result3);
        
        verify(dataManager, never()).updateRecord(anyString(), anyString(), anyString());
    }

    // registration deadline validation
    @Test
    @DisplayName("Registration deadline validation should work correctly")
    void testRegistrationDeadlineValidation() {
        // past deadline
        Date pastDeadline = Date.from(LocalDateTime.of(2026, 4, 1, 0, 0).atZone(ZoneId.systemDefault()).toInstant());
        validRace.setRegistrationDeadline(pastDeadline);
        String result1 = registrationService.signUpForRace(validRacer, validRace);
        assertEquals("Registration is closed for this race. Please select another.", result1);
        
        // no deadline (should allow registration)
        validRace.setRegistrationDeadline(null);
        doNothing().when(dataManager).updateRecord(anyString(), anyString(), anyString());
        String result2 = registrationService.signUpForRace(validRacer, validRace);
        assertNotNull(result2);
        assertFalse(result2.startsWith("Registration is closed"));
        
        verify(dataManager, times(2)).updateRecord(anyString(), anyString(), anyString());
    }

    // license validation
    @Test
    @DisplayName("License validation should work correctly")
    void testLicenseValidation() {
        // expired license
        Date pastExpiration = Date.from(LocalDateTime.of(2026, 4, 1, 0, 0).atZone(ZoneId.systemDefault()).toInstant());
        validLicense.setExpirationDate(pastExpiration);
        String result1 = registrationService.signUpForRace(validRacer, validRace);
        assertEquals("Invalid or expired license. Please renew your license before registering.", result1);
        
        // null expiration date
        validLicense.setExpirationDate(null);
        String result2 = registrationService.signUpForRace(validRacer, validRace);
        assertEquals("Invalid or expired license. Please renew your license before registering.", result2);
        
        verify(dataManager, never()).updateRecord(anyString(), anyString(), anyString());
    }

    // category and capacity validation
    @Test
    @DisplayName("Category and capacity validation should work correctly")
    void testCategoryAndCapacityValidation() {
        // category not allowed
        validRacer.setCategory(3); // not in allowed categories (1, 2)
        String result1 = registrationService.signUpForRace(validRacer, validRace);
        assertEquals("Your category is not allowed for this race. Please select another.", result1);
        
        // reset category
        validRacer.setCategory(1);
        
        // race full
        validRace.setParticipantLimit(1);
        validRace.getRegistrations().add(new RaceReg("REG001", validRacer, validRace, new Date(), "CONFIRMED"));
        String result2 = registrationService.signUpForRace(validRacer, validRace);
        assertEquals("This race is full. Please select another.", result2);
        
        verify(dataManager, never()).updateRecord(anyString(), anyString(), anyString());
    }

    // null DataManager object and DataManager exceptions
    @Test
    @DisplayName("Error handling for null DataManager object and DataManager exceptions should work correctly")
    void testErrorHandling() {
        // null data manager
        RegistrationService serviceWithNullDataManager = new RegistrationService(null);
        String result1 = serviceWithNullDataManager.signUpForRace(validRacer, validRace);
        assertEquals("Error: Data manager is not available.", result1);
        
        // DataManager exception
        doThrow(new RuntimeException("Database error")).when(dataManager).updateRecord(anyString(), anyString(), anyString());
        String result2 = registrationService.signUpForRace(validRacer, validRace);
        assertEquals("Error: Unable to save registration data.", result2);
    }
}
