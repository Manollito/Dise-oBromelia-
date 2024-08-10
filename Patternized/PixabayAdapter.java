package Patternized;

public class PixabayAdapter implements APIAdapter{
    
    public JSONObject json;
    
    public UnplashAdapter(JSONObject json){
        this.json = json;
    }
    
    public JSONObject transformJson(){
        
        // Se modifican los campos del json para normalizarlo
        for (int i = 0; i < json.length(); i++) {
            //Se asignan nombre a los campos dentro del JSON que sean comunes para realizar relaciones entre ambas API´s, dichos campos contarán con un nombre determinado antes
            //del proceso con el fin de relacionar los espacios, siempre y cuando exiten los campos en ambos JSON
        }
        
        return json;
    }
    
}
