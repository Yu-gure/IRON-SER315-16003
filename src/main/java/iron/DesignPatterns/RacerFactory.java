package iron.DesignPatterns;

import iron.model.License;
import iron.model.Racer;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Creator - uses parameterized factory method to create
 * different categories of Racers based on category input.
 */
public class RacerFactory {

    private Racer racer;

    public Racer getRacer(String userId, String name,
                          String paymentInfo, int category,
                          RegistrationService registrationService) {
        if (racer == null) {
            racer = createRacer(userId, name, paymentInfo,
                    category, registrationService);
        }
        return racer;
    }

    public Racer createRacer(String userId, String name,
                             String paymentInfo, int category,
                             RegistrationService registrationService) {
        Date issueDate = Date.from(LocalDate.now()
                .atStartOfDay(ZoneOffset.UTC).toInstant());
        Date expirationDate = Date.from(LocalDate.now().plusYears(1)
                .atStartOfDay(ZoneOffset.UTC).toInstant());

        License license = new License("LIC-" + userId,
                issueDate, expirationDate, category);

        if (category == 1) {
            System.out.println("Creating Category 1 (Elite) Racer: " + name);
            return new Racer(userId, name, 1, paymentInfo,
                    license, registrationService);
        } else if (category == 2) {
            System.out.println("Creating Category 2 (Intermediate) Racer: " + name);
            return new Racer(userId, name, 2, paymentInfo,
                    license, registrationService);
        } else if (category == 3) {
            System.out.println("Creating Category 3 (Beginner) Racer: " + name);
            return new Racer(userId, name, 3, paymentInfo,
                    license, registrationService);
        } else {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
    }
}