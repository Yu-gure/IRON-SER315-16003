package iron.controller;

import iron.model.DataManager;

public class RaceController {
    private DataManager dataManager;
    
    public RaceController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public void createRace() {
        // TODO: Implement logic
    }
    
    public void updateRace() {
        // TODO: Implement logic
    }
    
    public void setParticipantLimit() {
        // TODO: Implement logic
    }
    
    public void setRegistrationDeadline() {
        // TODO: Implement logic
    }
    
    public void enterResults() {
        // TODO: Implement logic
    }
}