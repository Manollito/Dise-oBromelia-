package Patternized;


import java.util.List;

public class BromeliaInterface {
    
    public static void main(String args[][]){
        
        //algoritmo es el ejemplo utilizado de lo que el usuario desea para realizar el ranking de la fotos, en este caso se utiliza CommentAlgorithm filtrando las fotos
        //por comentarios
        SelectionAlgorithm algoritmo = new CommentsAlgorithm(); 

        //Las URL representan las API, además se le pasa el algoritmo por el cual se realizará el ranking
        BromeliaPictInventory app = new BromeliaPictInventory(algoritmo, "KEYPixabay", "KEYUnsplash");

        //Se inicializan los adapters de cada API
        APIAdapter pixabayAdapter = new PixabayAdapter();
        APIAdapter unplashAdapter = new UnplashAdapter();

        //Se envían como parámetro los Adaptes junto a su respecto URL
        JSONObject pixabay = app.callApiPixabay("query", pixabayAdapter,  "URLPixabay");
        JSONObject unplash = app.callApiUnplash("query", unplashAdapter, "URLUnsplash");

        //Se crea un JSON que contenga todos los elementos de ambas API´s de manera combinada y se realiza el ranking según el algoritmo que se determine
        List<JSONObject> photos = app.rankPhotosResult( Unplash, pixabay);

        //Con el ranking generado, se procede a crear el Icon con las fotos correspondientes.
        app.createIcon(photos);
    }
    
}
