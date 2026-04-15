package iron.model;

import java.util.List;
import iron.controller.RegistrationService;

public class Racer extends User {
    private int category;
    private String paymentInfo;
    private License license;
    private List<RaceResults> raceHistory; 
    private List<RaceReg> registrations;
    private List<Notification> notifications;
    private RegistrationService registrationService;
    
    public Racer(String userId, String name, int category, String paymentInfo, License license, RegistrationService registrationService) {
        super(userId, name);
        this.category = category;
        this.paymentInfo = paymentInfo;
        this.license = license;
        this.registrationService = registrationService;
    }

    public int getCategory() { return category; }
    public void setCategory(int category) { this.category = category; }
    public String getPaymentInfo() { return paymentInfo; }
    public void setPaymentInfo(String paymentInfo) { this.paymentInfo = paymentInfo; }
    public License getLicense() { return license; }
    public void setLicense(License license) { this.license = license; }
    public List<RaceResults> getRaceHistory() { return raceHistory; }
    public void setRaceHistory(List<RaceResults> raceHistory) { this.raceHistory = raceHistory; }
    public List<RaceReg> getRegistrations() { return registrations; }
    public void setRegistrations(List<RaceReg> registrations) { this.registrations = registrations; }
    public List<Notification> getNotifications() { return notifications; }
    public void setNotifications(List<Notification> notifications) { this.notifications = notifications; }
    public RegistrationService getRegistrationService() { return registrationService; }
    public void setRegistrationService(RegistrationService registrationService) { this.registrationService = registrationService; }
}