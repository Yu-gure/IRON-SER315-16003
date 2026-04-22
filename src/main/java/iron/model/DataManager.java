package iron.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    private String folderPath;
    private final Gson gson = new Gson();

    public DataManager(String folderPath) {
        this.folderPath = folderPath;
    }

    public String getFolderPath() { return folderPath; }
    public void setFolderPath(String folderPath) { this.folderPath = folderPath; }
    
    public void saveData(String fileName, String jsonString) {
        try {
            String json = gson.toJson(jsonString);
            Files.write(Paths.get(this.folderPath + fileName + ".json"), json.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //put object into map then Gson converts the whole map to the Json
    public String loadData(String fileName, String id) throws IOException {
       try {
           String json = Files.readString(Path.of(folderPath + "/" + fileName));
           Map<String, String> dataMap = gson.fromJson(json, HashMap.class);
           return dataMap.get(id);
       }
       catch(IOException e) {
           e.printStackTrace();
           return null;
       }
       }

    //reads the file then GSON converts JSON back into the map and gets the Id then returns a string
    public void updateRecord(String fileName, String id, String newData) throws IOException {
        try {
            String json = Files.readString(Path.of(folderPath + "/" + fileName));
            String updated = json.replace(id, newData);
            Files.writeString(Path.of(folderPath + "/" + fileName), updated);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
}