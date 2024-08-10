package Patternized;

import java.util.ArrayList;
import java.util.List;


public class BromeliaPictInventory {
    
    private String unplashKey;
    private String pixabayKey;
    private SelectionAlgorithm algoritmo;
    
    public BromeliaPictInventory(SelectionAlgorithm algoritmo, String unplashKey, String pixabayKey){
        this.unplashKey = unplashKey;
        this.pixabayKey = pixabayKey;
        this.algoritmo = algoritmo;
    }
    
    // Método para hacer una solicitud GET al API
    public String getRequest(String apiUrl) {
        StringBuilder response = new StringBuilder();
        try {
            //Aquí iría la lógica con la que se optiene el JSON de cada API
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    // Método para comunicarse con la API de unplash 
    public JSONObject callApiUnplash(String query, APIAdapter adapter, String URLApi) {
        String url = URLApi + query + "&client_id=" + unplashKey;
        String result = getRequest(url);
        JSONObject json = new JSONObject(result);
        return adapter.transformJson(json.getJSONArray("results"));
    }

    // Método para comunicarse con la API de Pixabay 
    public JSONObject callApiPixabay(String query, APIAdapter adapter, String URLApi) {
        String url = URLApi + pixabayKey + "&q=" + query + "&image_type=photo";
        String result = getRequest(url);
        JSONObject json = new JSONObject(result);
        return adapter.transformJson(json.getJSONArray("hits"));
    }
    
    public List<JSONObject> rankPhotosResult(JSONObject UnplashJson, JSONObject PixabayJson){   
     
        // Combinar las fotos de ambas API's en una sola lista
        
        List<JSONObject> totalPhotos = new ArrayList<>();
        for (int i = 0; i < UnplashJson.length(); i++) {
            totalPhotos.add(UnplashJson.getJSONObject(i));
        }
        for (int i = 0; i < PixabayJson.length(); i++) {
            totalPhotos.add(PixabayJson.getJSONObject(i));
        }
        
        List<JSONObject> sordedPhotos = this.algoritmo.rankPhotos(totalPhotos);
        
        return sordedPhotos;
      
    }
    
    public void createIcon(ArrayList<List<Integer>> photosList){
        
       // .................
        
    }
    

}
