package iron.model;

import java.util.Date;

public class RaceReg {
    private String registrationId;
    private Racer racer;
    private Race race;
    private Date registrationDate;
    private String status;
    
    public RaceReg(String registrationId, Racer racer, Race race, Date registrationDate, String status) {
        this.registrationId = registrationId;
        this.racer = racer;
        this.race = race;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public String getRegistrationId() { return registrationId; }
    public void setRegistrationId(String registrationId) { this.registrationId = registrationId; }
    public Racer getRacer() { return racer; }
    public void setRacer(Racer racer) { this.racer = racer; }
    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }
    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
