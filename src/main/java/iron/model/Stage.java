package iron.model;

public class Stage {
    private String stageId;
    private Race race;
    private String description;
    
    public Stage(String stageId, Race race, String description) {
        this.stageId = stageId;
        this.race = race;
        this.description = description;
    }

    public String getStageId() { return stageId; }
    public void setStageId(String stageId) { this.stageId = stageId; }
    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}