package iron.controller;

import iron.model.RaceRev;
import iron.model.Race;
import iron.model.Racer;
import iron.model.DataManager;

public class ReviewService {
    private DataManager dataManager;
    
    public ReviewService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() { return dataManager; }
    public void setDataManager(DataManager dataManager) { this.dataManager = dataManager; }
    
    public RaceRev createReview(Race race, Racer racer, int rating, String comment) {
        // TODO: Implement logic to generate a review
        return null;
    }
    
    public boolean verifyParticipation(Race race, Racer racer) {
        // TODO: Enforce rule: Check Racer's raceHistory to ensure they participated before allowing a review
        return false;
    }
    
    public void manageReviews() {
        // TODO: Implement logic for admins or organizers to moderate reviews
    }
}