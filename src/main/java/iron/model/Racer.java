package iron.model;

import java.util.List;

import iron.controller.RegistrationService;

public class Racer extends User {
    public int category;
    public String paymentInfo;
    
    // Owns 1 License
    public License license;
    
    // List raceHistory as defined in diagram
    public List<RaceResults> raceHistory; 
    
    // 1 Racer submits * RaceReg
    public List<RaceReg> registrations;
    
    // 1 Racer receives * Notification
    public List<Notification> notifications;
    
    // 1 Racer uses 1 RegistrationService
    public RegistrationService registrationService;
    
    // TODO: Add constructor, getters, and setters
}