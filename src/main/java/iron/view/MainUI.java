package iron.view;

public class MainUI {
    private Object currentDashboard;
    private OrganizerDashboard organizerDashboard;
    private RacerDashboard racerDashboard;
    private AdminDashboard adminDashboard;
    
    public MainUI() {
        // Constructor logic
    }

    public Object getCurrentDashboard() { return currentDashboard; }
    public void setCurrentDashboard(Object currentDashboard) { this.currentDashboard = currentDashboard; }
    public OrganizerDashboard getOrganizerDashboard() { return organizerDashboard; }
    public void setOrganizerDashboard(OrganizerDashboard organizerDashboard) { this.organizerDashboard = organizerDashboard; }
    public RacerDashboard getRacerDashboard() { return racerDashboard; }
    public void setRacerDashboard(RacerDashboard racerDashboard) { this.racerDashboard = racerDashboard; }
    public AdminDashboard getAdminDashboard() { return adminDashboard; }
    public void setAdminDashboard(AdminDashboard adminDashboard) { this.adminDashboard = adminDashboard; }
    
    public void setDash(String dashboardType) {
        // TODO: Implement logic to switch currentDashboard
    }
}