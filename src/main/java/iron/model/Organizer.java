package iron.model;

import java.util.List;
import iron.controller.RaceController;

public class Organizer extends User {
    private RaceController raceController;
    private List<Race> managedRaces;
    
    public Organizer(String userId, String name, RaceController raceController, List<Race> managedRaces) {
        super(userId, name);
        this.raceController = raceController;
        this.managedRaces = managedRaces;
    }

    public RaceController getRaceController() { return raceController; }
    public void setRaceController(RaceController raceController) { this.raceController = raceController; }
    public List<Race> getManagedRaces() { return managedRaces; }
    public void setManagedRaces(List<Race> managedRaces) { this.managedRaces = managedRaces; }
}