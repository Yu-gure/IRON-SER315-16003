package iron.view;

import iron.model.Organizer;

public class OrganizerDashboard {
    private Organizer organizer;
    
    public OrganizerDashboard(Organizer organizer) {
        this.organizer = organizer;
    }

    public Organizer getOrganizer() { return organizer; }
    public void setOrganizer(Organizer organizer) { this.organizer = organizer; }
    
    public void displayOrganizerMenu() {
        // TODO: Implement UI logic
    }
}