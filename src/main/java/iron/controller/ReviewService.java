package iron.controller;

import iron.model.DataManager;
import iron.model.Race;
import iron.model.RaceRev;
import iron.model.Racer;

public class ReviewService {
    
    public DataManager dataManager;
    
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