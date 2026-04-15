package iron.controller;

import iron.model.DataManager;

public class AdminController {
    private DataManager dataManager;
    
    public AdminController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public void manageUsers() {
        // TODO: Implement logic
    }
    
    public void manageLicenses() {
        // TODO: Implement logic
    }
    
    public void manageSettings() {
        // TODO: Implement logic
    }
}