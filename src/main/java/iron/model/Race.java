package iron.model;

import java.util.Date;
import java.util.List;

public class Race {
    private String raceId;
    private String title;
    private Date date;
    private String type; 
    private float miles;
    private String route;
    private int participantLimit;
    private Date registrationDeadline;
    private boolean official;
    private List<Integer> allowedCategories; 
    private List<Stage> stages;
    private List<RaceReg> registrations;
    private List<RaceResults> results;
    private List<RaceRev> reviews;
    
    public Race(String raceId, String title, Date date, float miles, int participantLimit, boolean official) {
        this.raceId = raceId;
        this.title = title;
        this.date = date;
        this.miles = miles;
        this.participantLimit = participantLimit;
        this.official = official;
    }

    public String getRaceId() { return raceId; }
    public void setRaceId(String raceId) { this.raceId = raceId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public float getMiles() { return miles; }
    public void setMiles(float miles) { this.miles = miles; }
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    public int getParticipantLimit() { return participantLimit; }
    public void setParticipantLimit(int participantLimit) { this.participantLimit = participantLimit; }
    public Date getRegistrationDeadline() { return registrationDeadline; }
    public void setRegistrationDeadline(Date registrationDeadline) { this.registrationDeadline = registrationDeadline; }
    public boolean isOfficial() { return official; }
    public void setOfficial(boolean official) { this.official = official; }
    public List<Integer> getAllowedCategories() { return allowedCategories; }
    public void setAllowedCategories(List<Integer> allowedCategories) { this.allowedCategories = allowedCategories; }
    public List<Stage> getStages() { return stages; }
    public void setStages(List<Stage> stages) { this.stages = stages; }
    public List<RaceReg> getRegistrations() { return registrations; }
    public void setRegistrations(List<RaceReg> registrations) { this.registrations = registrations; }
    public List<RaceResults> getResults() { return results; }
    public void setResults(List<RaceResults> results) { this.results = results; }
    public List<RaceRev> getReviews() { return reviews; }
    public void setReviews(List<RaceRev> reviews) { this.reviews = reviews; }
}

enum RaceType {
    // TODO: Define race types
}