package iron.controller;

import iron.model.DataManager;
import iron.model.RaceResults;
import iron.model.Racer;

public class UpgradeService {
    private DataManager dataManager;
    private NotificationService notificationService;
    private LicenseService licenseService;

    public UpgradeService(DataManager dataManager) {
        this.dataManager = dataManager;
    }
    public UpgradeService(DataManager dataManager, NotificationService notificationService, LicenseService licenseService) {
        this.dataManager = dataManager;
        this.notificationService = notificationService;
        this.licenseService = licenseService;
    }

    /**
     * Checks if a racer is eligible for a category upgrade.
     * Racer must have a valid license and at least 3 podium finishes.
     *
     * @param racer the racer to check
     * @return true if eligible, false otherwise
     */
    public boolean checkUpgradeEligibility(Racer racer) {

        // Null checks
        if (racer == null || racer.getRaceHistory() == null) {
            return false;
        }

        // Must have valid unexpired license
        if (licenseService.checkExpiration(racer.getLicense())) {
            return false;
        }

        // Count podium finishes
        int podiums = 0;
        for (RaceResults result : racer.getRaceHistory()) {
            if (result.isPodiumFinish()) {
                podiums++;
            }
        }

        return podiums >= 3;

    }

    /**
     * Upgrades a racer's category by one level and notifies them.
     *
     * @param racer the racer to upgrade
     */
    public void upgradeRacerCategory(Racer racer) {

        // Null check
        if (racer == null) {
            return;
        }

        racer.setCategory(racer.getCategory() - 1);

        // Save data
        if (dataManager != null) {
            dataManager.updateRecord("racers", racer.getUserId(), racer.toString());
        }

        // Notify racer via Observer pattern
        notificationService.sendNotification(racer,
                "Congratulations! You have been upgraded to category " + racer.getCategory() + "!");
    }

}