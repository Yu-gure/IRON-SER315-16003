package iron.view;

import iron.model.Admin;

public class AdminDashboard {
    private Admin admin;
    
    public AdminDashboard(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    
    public void displayAdminMenu() {
        // TODO: Implement UI logic
    }
}