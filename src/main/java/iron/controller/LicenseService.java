package iron.controller;

import iron.model.DataManager;
import iron.model.License;
import iron.model.Racer;

public class LicenseService {
    
    // Saves and loads license data
    public DataManager dataManager;
    
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