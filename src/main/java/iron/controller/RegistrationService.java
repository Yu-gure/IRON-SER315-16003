package iron.controller;

import iron.model.DataManager;

public class RegistrationService {
    private DataManager dataManager;
    
    public RegistrationService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public void signUpForRace() {
        // TODO: Implement logic
    }
    
    public void purchaseLicense() {
        // TODO: Implement logic
    }
    
    public void reviewRace() {
        // TODO: Implement logic
    }
}