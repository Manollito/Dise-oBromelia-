package Naive;

import java.util.List;

public class BromeliaInterface {
    
    public static void main(String args[][]){
        
        BromeliaPictInventory app = new BromeliaPictInventory("URL", "URL");
        JSONObject pixabay = app.callApiPixabay("query");
        JSONObject Unplash = app.callApiUnplash("query");
        List<JSONObject> photos = app.rankPhotosResult(Unplash, pixabay);
        app.createIcon(photos);
    }
    
}
