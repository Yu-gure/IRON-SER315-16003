package iron.controller;

import iron.model.License;
import iron.model.Racer;
import iron.model.DataManager;

public class LicenseService {
    private DataManager dataManager;
    
    public LicenseService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public License issueLicense(Racer racer, int categoryLevel) {
        // TODO: Implement logic to issue a new license
        return null;
    }
    
    public void renewLicense(License license) {
        // TODO: Implement logic to update the expiryDate
    }
    
    public boolean checkExpiration(License license) {
        // TODO: Implement logic to check if current date is past expiryDate
        return false;
    }
    
    public boolean validateOfficialRaceEntry(Racer racer) {
        // TODO: Implement logic to verify if the racer has a valid license for official races
        return false;
    }
}