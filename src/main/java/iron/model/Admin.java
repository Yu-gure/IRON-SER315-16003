package iron.model;

import iron.controller.AdminController;
public class Admin extends User {
   private AdminController adminController;
    
    public Admin(String userId, String name, AdminController adminController) {
        super(userId, name);
        this.adminController = adminController;
    }

    public AdminController getAdminController() { return adminController; }
    public void setAdminController(AdminController adminController) { this.adminController = adminController; }
    // TODO: Add constructor, getters, and setters
}
