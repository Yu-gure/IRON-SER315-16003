package iron.model;

import java.util.Date;

public class License {
    public String licenseId;
    public Date issueDate;
    public Date expirationDate;
    public int categoryLevel;
    
    // TODO: Add constructor
    
    // checks current date against expirationDate
    public boolean isValid() {
        // TODO
        return false; 
    }
}