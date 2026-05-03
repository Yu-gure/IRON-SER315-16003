package iron;

import iron.DesignPatterns.RacerFactory;
import iron.DesignPatterns.RegistrationService;
import iron.controller.*;
import iron.model.*;
import iron.view.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Setup services
        DataManager dataManager = new DataManager("data/");
        LicenseService licenseService = new LicenseService(dataManager);
        NotificationService notificationService = new NotificationService(dataManager);
        RegistrationService registrationService = new RegistrationService(dataManager);

        // Preload racers using factory
        RacerFactory factory = new RacerFactory();
        List<Racer> racers = new ArrayList<>();
        racers.add(factory.createRacer("R001", "Khanh",   "PAY001", 1, registrationService));
        racers.add(factory.createRacer("R002", "Zachary", "PAY002", 2, registrationService));
        racers.add(factory.createRacer("R003", "Timothy", "PAY003", 2, registrationService));
        racers.add(factory.createRacer("R004", "Alissa",  "PAY004", 3, registrationService));
        racers.add(factory.createRacer("R005", "Connor",  "PAY005", 3, registrationService));

        // Issue licenses for all racers
        for (Racer r : racers) {
            licenseService.issueLicense(r, r.getCategory());
        }

        // Setup dashboards and register as observers
        List<RacerDashboard> dashboards = new ArrayList<>();
        for (Racer r : racers) {
            RacerDashboard dashboard = new RacerDashboard(r);
            notificationService.addObserver(dashboard);
            dashboards.add(dashboard);
        }

        // Build race dates using Calendar
        Calendar cal = Calendar.getInstance();

        // Race date - 30 days from now for all races
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date futureRaceDate = cal.getTime();

        // Tour de Tucson deadline - 7 days from now
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date tucsonDeadline = cal.getTime();

        // Tour de Maui deadline - 14 days from now
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 14);
        Date mauiDeadline = cal.getTime();

        // Tour de Portland deadline - 7 days AGO (closed)
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        Date portlandDeadline = cal.getTime();

        // Preload races
        List<Race> races = new ArrayList<>();

        // Tour de Tucson - open, category 1 & 2
        Race tucson = new Race("RACE001", "Tour de Tucson",
                futureRaceDate, 50.0f, 50, true);
        tucson.setRegistrations(new ArrayList<>());
        tucson.setRegistrationDeadline(tucsonDeadline);
        List<Integer> tucsonCats = new ArrayList<>();
        tucsonCats.add(1);
        tucsonCats.add(2);
        tucson.setAllowedCategories(tucsonCats);

        // Tour de Maui - open, category 3 only
        Race maui = new Race("RACE002", "Tour de Maui",
                futureRaceDate, 30.0f, 30, true);
        maui.setRegistrations(new ArrayList<>());
        maui.setRegistrationDeadline(mauiDeadline);
        List<Integer> mauiCats = new ArrayList<>();
        mauiCats.add(3);
        maui.setAllowedCategories(mauiCats);

        // Tour de Portland - closed
        Race portland = new Race("RACE003", "Tour de Portland",
                futureRaceDate, 40.0f, 40, true);
        portland.setRegistrations(new ArrayList<>());
        portland.setRegistrationDeadline(portlandDeadline);
        List<Integer> portlandCats = new ArrayList<>();
        portlandCats.add(1);
        portlandCats.add(2);
        portlandCats.add(3);
        portland.setAllowedCategories(portlandCats);

        races.add(tucson);
        races.add(maui);
        races.add(portland);

        // Start UI
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            // Pick a racer
            System.out.println("\n====== SELECT RACER ======");
            for (int i = 0; i < racers.size(); i++) {
                System.out.println((i + 1) + ". " + racers.get(i).getName()
                        + " (Category " + racers.get(i).getCategory() + ")");
            }
            System.out.println("0. Exit");
            System.out.print("\nEnter choice > ");
            int racerChoice = Integer.parseInt(scanner.nextLine());

            if (racerChoice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            Racer selectedRacer = racers.get(racerChoice - 1);
            RacerDashboard selectedDashboard = dashboards.get(racerChoice - 1);

            System.out.println("\nWelcome " + selectedRacer.getName() + "!");

            boolean racerActive = true;  // <-- add this flag
            while (racerActive) {        // <-- wrap menu in inner loop

                int mainChoice = ui.showMainMenu();

                switch (mainChoice) {
                    case 0:
                        racerActive = false;
                        break;

                    case 1:
                        int raceChoice = ui.showAvailableRaces();
                        if (raceChoice == 0) break;

                        Race selectedRace = races.get(raceChoice - 1);

                        // Check registration open
                        Date now = new Date();
                        if (!now.before(selectedRace.getRegistrationDeadline())) {
                            ui.showRegistrationClosed(selectedRace.getTitle());
                            break;
                        }

                        int regChoice = ui.showRegistrationOpen(selectedRace.getTitle());
                        if (regChoice == 0) break;

                        // Check license
                        if (licenseService.checkExpiration(selectedRacer.getLicense())) {
                            ui.showLicenseInvalid();
                            break;
                        }

                        int licChoice = ui.showLicenseValid();
                        if (licChoice == 0) break;

                        // Check category
                        if (!selectedRace.getAllowedCategories()
                                .contains(selectedRacer.getCategory())) {
                            ui.showCategoryNotAllowed();
                            break;
                        }

                        int catChoice = ui.showCategoryAllowed();
                        if (catChoice == 0) break;

                        // Check slots
                        if (selectedRace.getRegistrations().size()
                                >= selectedRace.getParticipantLimit()) {
                            ui.showSlotsUnavailable();
                            break;
                        }

                        int slotChoice = ui.showSlotsAvailable();
                        if (slotChoice == 0) break;

                        // Register and notify
                        String result = registrationService
                                .signUpForRace(selectedRacer, selectedRace);
                        if (!result.startsWith("Error")) {
                            ui.registrationSuccessful(selectedRace.getTitle());
                            // Observer fires automatically
                            notificationService.sendNotification(selectedRacer,
                                    selectedRacer.getName() + " is registered for "
                                            + selectedRace.getTitle() + "!");
                            selectedDashboard.displayNotifications();
                        }
                        break;

                    case 2:
                        System.out.println("\n====== LICENSE INFO ======");
                        System.out.println("License ID: " + selectedRacer.getLicense().getLicenseId());
                        System.out.println("Category Level: " + selectedRacer.getLicense().getCategoryLevel());
                        System.out.println("Expires: " + selectedRacer.getLicense().getExpirationDate());
                        break;

                    case 3:
                        System.out.println("\n====== RACE HISTORY ======");
                        if (selectedRacer.getRaceHistory() == null ||
                                selectedRacer.getRaceHistory().isEmpty()) {
                            System.out.println("No race history yet.");
                        } else {
                            for (RaceResults r : selectedRacer.getRaceHistory()) {
                                System.out.println(r.getRace().getTitle()
                                        + " - Placement: " + r.getPlacement());
                            }
                        }
                        break;

                    case 4:
                        System.out.println("\n====== SETTINGS ======");
                        System.out.println("Settings coming soon.");
                        break;
                }
            }
        }
    }
}