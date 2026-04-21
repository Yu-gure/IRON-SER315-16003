package iron.model;

public class RaceResults {
    private String resultId;
    private Race race;
    private Racer racer;
    private int placement;
    private boolean podiumFinish;
    
    public RaceResults(String resultId, Race race, Racer racer, int placement, boolean podiumFinish) {
        this.resultId = resultId;
        this.race = race;
        this.racer = racer;
        this.placement = placement;
        this.podiumFinish = podiumFinish;
    }

    public String getResultId() { return resultId; }
    public void setResultId(String resultId) { this.resultId = resultId; }
    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }
    public Racer getRacer() { return racer; }
    public void setRacer(Racer racer) { this.racer = racer; }
    public int getPlacement() { return placement; }
    public void setPlacement(int placement) { this.placement = placement; }
    public boolean isPodiumFinish() { return podiumFinish; }
    public void setPodiumFinish(boolean podiumFinish) { this.podiumFinish = podiumFinish; }
}