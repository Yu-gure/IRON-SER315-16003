package iron.controller;

public class Authenticator {
    private String filePath;
    
    public Authenticator(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    
    public String validate(String user, String pass) {
        // TODO: Implement validation logic
        return null;
    }
}