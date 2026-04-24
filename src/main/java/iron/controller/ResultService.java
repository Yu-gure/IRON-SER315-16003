package iron.controller;

import iron.model.RaceResults;
import iron.model.Race;
import iron.model.Racer;
import iron.model.DataManager;
import java.util.List;

public class ResultService {
    private DataManager dataManager;
    
    public ResultService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public void submitResult(Race race, Racer racer, int placement) {
        // TODO: Implement logic for organizers to enter results
    }
    
    public List<RaceResults> lookupResults(Race race) {
        // TODO: Implement logic to retrieve all results for a specific race
        return null;
    }
    
    public List<RaceResults> getPodium(Race race) {
        // TODO: Implement logic to retrieve the top placements (e.g., 1st, 2nd, 3rd)
        return null;
    }
}