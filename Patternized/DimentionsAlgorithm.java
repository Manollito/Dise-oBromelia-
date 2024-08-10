package Patternized;


public class DimentionsAlgorithm implements SelectionAlgorithm {
        
    public void rankPhotos(JSONObject jsonPhotos) {
    
        // Realiza el ranking de las fotos por dimensiones
        // Ya que está normalizado, se realiza una comparación sencilla de todos los elementos dentro del JSON, pero si no lo estuviera no se hubieran podido juntar ambos JSON 
        // debido a que poseen espacios distintos, un ejemplo es el siguiente: jsonTemporal.get("imageWidth") y jsonTemporal.get("width"), donde se obtienen los mismos valores en
        // los JSON pero con distinto nombre dentro del mismo.

        // Se utiliza un algoritmo QuickSort que recorrar todos los elementos del JSON y los ordene de mayor a menor, luego ingresar en el ranking los elementos correspondientes
        // (ya sea top 1, top 10, etc) según indiquen en el algoritmo que se selecciona en el principio.
        
        List<JSONObject> sordedPhotos = new ArrayList<>();
        
        JSONObject jsonTemporal = totalPhotos.get(0);
        for (int i = 0; i < totalPhotos.length(); i++) {
            for (int i = 0; i < totalPhotos.length(); i++) {
                
                if(jsonTemporal.get("dimensions")<totalPhotos.get(i).get("dimensions")){
                    jsonTemporal = totalPhotos.get(i)
                }
                
                  
            }
            sordedPhotos.add(jsonTemporal);
            totalPhotos.delete(jsonTemporal);
        }
        
    
        return ranking
    }
}
