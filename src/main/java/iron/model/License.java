package iron.model;

import java.util.Date;

public class License {
    private String licenseId;
    private Date issueDate;
    private Date expirationDate;
    private int categoryLevel;
    
    //constructor
    public License(String licenseId, Date issueDate, Date expirationDate, int categoryLevel) {
        this.licenseId = licenseId;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.categoryLevel = categoryLevel;
    }

    public String getLicenseId() { return licenseId; }
    public void setLicenseId(String licenseId) { this.licenseId = licenseId; }
    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }
    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }
    public int getCategoryLevel() { return categoryLevel; }
    public void setCategoryLevel(int categoryLevel) { this.categoryLevel = categoryLevel; }
    
    // checks current date against expirationDate
    public boolean isValid() {
        // TODO
        return false; 
    }
}