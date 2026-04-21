package iron.controller;

import java.util.Date;
import java.util.UUID;

import iron.model.DataManager;
import iron.model.Race;
import iron.model.RaceReg;
import iron.model.Racer;

public class RegistrationService {
    private DataManager dataManager;
    
    public RegistrationService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    /**
     * Signs up a racer for a race
     * @param racer The racer to sign up
     * @param race The race to sign up for
     * @return The registration ID if successful, or an error message if not
     */
    public String signUpForRace(Racer racer, Race race) {
        try {
            // Validate input parameters
            if (racer == null) {
                return "Error: Racer information is required.";
            }
            if (race == null) {
                return "Error: Race information is required.";
            }
            if (racer.getUserId() == null || racer.getUserId().trim().isEmpty()) {
                return "Error: Invalid racer ID.";
            }
            if (race.getRaceId() == null || race.getRaceId().trim().isEmpty()) {
                return "Error: Invalid race ID.";
            }
            
            Date currentDate = new Date();
            
            // check if registration is open
            if (race.getRegistrationDeadline() != null) {
                if (!currentDate.before(race.getRegistrationDeadline())) {
                    return "Registration is closed for this race. Please select another.";
                }
            }
            
            // check if license is valid
            if (racer.getLicense() == null || racer.getLicense().getExpirationDate() == null || 
                !currentDate.before(racer.getLicense().getExpirationDate())) {
                return "Invalid or expired license. Please renew your license before registering.";
            }
            
            // check if category is allowed
            if (race.getAllowedCategories() != null) {
                if (!race.getAllowedCategories().contains(racer.getCategory())) {
                    return "Your category is not allowed for this race. Please select another.";
                }
            }
            
            // check if race is full
            if (race.getParticipantLimit() > 0 && race.getRegistrations() != null) {
                if (race.getRegistrations().size() >= race.getParticipantLimit()) {
                    return "This race is full. Please select another.";
                }
            }
        
            // Create Registration
            String registrationId = UUID.randomUUID().toString();
            Date registrationDate = new Date();
            String status = "CONFIRMED";
            
            RaceReg registration = new RaceReg(registrationId, racer, race, registrationDate, status);
                
            // Add registration to race
            if (race.getRegistrations() != null) {
                race.getRegistrations().add(registration);
            }
                
            // Add registration to racer
            if (racer.getRegistrations() != null) {
                racer.getRegistrations().add(registration);
            }
                
            // Save data using DataManager
            try {
                if (dataManager != null) {
                    dataManager.updateRecord("races", race.getRaceId(), race.toString());
                    dataManager.updateRecord("racers", racer.getUserId(), racer.toString());
                } else {
                    return "Error: Data manager is not available.";
                }
            } catch (Exception e) {
                return "Error: Unable to save registration data.";
            }
                
            return registrationId;
                
        } catch (Exception e) {
            return "Error: An unexpected error occurred during registration. Please try again.";
        }
    }
    
    public void purchaseLicense() {
        // TODO: Implement logic
    }
    
    public void reviewRace() {
        // TODO: Implement logic
    }
}