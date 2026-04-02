package iron.core;

import java.util.Date;
import java.util.List;

public class Race {
    public String raceId;
    public String title;
    public Date date;
    public RaceType type; 
    public float miles;
    public String route;
    public int participantLimit;
    public Date registrationDeadline;
    public boolean official;
    public List<Integer> allowedCategories; 
    
    
    public List<Stage> stages;
    
    // Associations 
    public List<RaceReg> registrations;
    public List<RaceResults> results;
    public List<RaceRev> reviews;
    
    // TODO: Add constructor, getters, and setters
}

enum RaceType {
    // TODO: Define race types
}