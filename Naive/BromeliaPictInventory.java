package Naive;

import java.util.ArrayList;
import java.util.List;


public class BromeliaPictInventory {
    
    private String unplashKey;
    private String pixabayKey;
    
    public BromeliaPictInventory(String unplashKey, String pixabayKey){
        
        this.unplashKey = unplashKey;
        this.pixabayKey = pixabayKey;
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
    public JSONObject callApiUnplash(String query, String URLApi) {
        String url = URLApi + query + "&client_id=" + unplashKey;
        String result = getRequest(url);
        JSONObject json = new JSONObject(result);
        return json.getJSONArray("results");
    }

    // Método para comunicarse con la API de Pixabay 
    public JSONObject callApiPixabay(String query, String URLApi) {
        String url = URLApi + pixabayKey + "&q=" + query + "&image_type=photo";
        String result = getRequest(url);
        JSONObject json = new JSONObject(result);
        return json.getJSONArray("hits");
    }
    
    // Método para obtener el top 10 de las fotos de ambas API'S
    public List<JSONObject> rankPhotosResult(JSONObject UnplashJson, JSONObject PixabayJson){   
        
        // Combinar las fotos de ambas API's en una sola lista
        
        List<JSONObject> totalPhotos = new ArrayList<>();
        for (int i = 0; i < UnplashJson.length(); i++) {
            totalPhotos.add(UnplashJson.getJSONObject(i));
        }
        for (int i = 0; i < PixabayJson.length(); i++) {
            totalPhotos.add(PixabayJson.getJSONObject(i));
        }
        
        // Ordenar la lista por la cantidad de likes, el width y el height de cada foto
        
        List<JSONObject> sordedPhotos = new ArrayList<>();
        
        JSONObject jsonTemporal = totalPhotos.get(0);
        
        // Listas para clasificar las fotos por likes, width y height
        int[] likes = new int[2];
        int[] width = new int[2];
        int[] height = new int[2];
        
        for (int i = 0; i < totalPhotos.length(); i++) {
            
            for (int i = 0; i < totalPhotos.length(); i++) {
                
             
                // Se obtiene los parametros likes, width y height dependiendo de cómo esté escrito en el 
                // JSON de cada API, el cual es un problema porque los campos en cada json están escritos 
                // de forma diferente, por lo que hay que realizar el proceso para verificar cual nombre es 
                // el correcto
               


                likes[0] = jsonTemporal.get("likes");
                likes[1] = totalPhotos.get(i).get("likes");

                width[0] = jsonTemporal.get("imageWidth") or jsonTemporal.get("width");
                width[1] = totalPhotos.get(i).get("imageWidth") or totalPhotos.get(i).get("width");

                height[0] = jsonTemporal.get("imageHeight") or jsonTemporal.get("height");
                height[1] = totalPhotos.get(i).get("imageHeight") or totalPhotos.get(i).get("height");

                if (likes[0] > likes[0] && width[0] > width[1] && height[0] > height [1]
                    jsonTemporal = totalPhotos.get(i);
                )
                  
                }
          
            
            sordedPhotos.add(jsonTemporal);
            totalPhotos.delete(jsonTemporal);
        }
        
       
        
        // Limitar los resultados a las top 10 fotos
        List<JSONObject> topPhotos = new ArrayList<>();
        
        for (int i = 0; i < 10; i ++) {
            topPhotos.add(totalPhotos.get(i));
        }
        
        return topPhotos
    }
    
    // Método que recibe las 10 mejores fotos y crea un icon basado en dichas fotos
    public void createIcon(ArrayList<List<Integer>> photosList){
        
       // .................
        
    }
    

}
