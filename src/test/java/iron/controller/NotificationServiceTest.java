package iron.controller;

import iron.model.DataManager;
import iron.model.License;
import iron.model.Racer;
import iron.view.RacerDashboard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class NotificationServiceTest {

    private NotificationService notificationService;
    private Racer racer;
    private RacerDashboard dashboard;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService(null); // null datamanager for now
        License license = new License("LIC001", new Date(), new Date(), 1);
        racer = new Racer("RACER001", "Ricky Bobby", 1, "PAY111", license, null);
        dashboard = new RacerDashboard(racer);
    }

    @Test
    void testSendNotification() {
        notificationService.sendNotification(racer, "You have been upgraded to category 2!");

        assertNotNull(racer.getNotifications());
        assertEquals(1, racer.getNotifications().size());
        assertEquals("You have been upgraded to category 2!", racer.getNotifications().get(0).getMessage());
    }

    @Test
    void testReceiveNotification() {
        notificationService.sendNotification(racer, "Race registration confirmed!");
        dashboard.displayNotifications();
    }

    @Test
    void testNullInputs() {
        notificationService.sendNotification(null, "test");
        notificationService.sendNotification(racer, null);
        assertNull(racer.getNotifications());
    }
}