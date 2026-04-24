package iron.controller;

import iron.model.License;
import iron.model.Racer;
import iron.model.DataManager;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class LicenseService {
    private DataManager dataManager;
    
    public LicenseService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public License issueLicense(Racer racer, int categoryLevel) {

        // Check for Racer argument
        if (racer == null) {
            return null;
        }

        String licenseID = UUID.randomUUID().toString();    // Generate ID
        Date issueDate = new Date();    // Date on object creation

        // Date methods are deprecated. Utilizing Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueDate);
        calendar.add(Calendar.YEAR, 1); // Add a year to the current date
        Date expirationDate = calendar.getTime();   // Set expiration date

        License license = new License(licenseID, issueDate, expirationDate, categoryLevel); // Generate new license

        racer.setLicense(license);  // Set racer's licence

        // Save data
        if (dataManager != null) {
            dataManager.updateRecord("racers", racer.getUserId(), racer.toString());
        }

        return license;
    }
    
    public void renewLicense(License license) {

        // Null check
        if (license == null) {
            return;
        }

        // Create Calendar object to set current date forward a year
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);

        license.setExpirationDate(calendar.getTime());  // Update the license expiration
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