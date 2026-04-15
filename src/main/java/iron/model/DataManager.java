package iron.model;

public class DataManager {
    private String folderPath;
    
    public DataManager(String folderPath) {
        this.folderPath = folderPath;
    }

    public String getFolderPath() { return folderPath; }
    public void setFolderPath(String folderPath) { this.folderPath = folderPath; }
    
    public void saveData(String fileName, String jsonString) {
        // TODO: Implement logic
    }
    
    public String loadData(String fileName) {
        // TODO: Implement logic
        return null;
    }
    
    public void updateRecord(String fileName, String id, String newData) {
        // TODO: Implement logic
    }
}