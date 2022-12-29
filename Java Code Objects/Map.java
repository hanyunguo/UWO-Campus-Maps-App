

public class Map {

    /*
    * The class map provide details information on the map of different buildings.
    IMPLEMENT!
    */
    
    /*Instance Variables*/
    private Layer[] layers;
    private Poi[] pois;
    private String name;
    private Building assignedBuilding;
    private final int MAX_POI = 20;
    private final int MAX_LAYER = 10;
    private int countP;
    private int countL;
    
    /*Constructors*/
    public Map (String mapName, Building building) {
        this.name = mapName;
        this.assignedBuilding = building;
        this.countP = this.countL = 0;
        this.layers = new Layer[MAX_LAYER];
        this.pois = new Poi[MAX_POI];
    }
    
    /*
    * Getter Methods
    */
    
    public String showBuildingName (){
        return this.assignedBuilding.getName();
    }
    
    public Building getBuilding () {
        return this.assignedBuilding;
    }
    
    public String getName (){
        return this.name;
    }
    
    public String showPois (){
        String mapPois = "";
        for (int i=0; i < countP; i++) {
            mapPois += pois[i].getName() + "\n";
        }
        return mapPois;
    }
    
    public String showLayers (){
        String mapLayers = "";
        for (int i=0; i < countL; i++) {
            mapLayers += layers[i].getName() + "\n";
        }
        return mapLayers;
    }
    
    public Poi findPoi (String name) {
        Poi found = null;
        for (int i=0;i<countP;i++) {
            Poi current = pois[i];
            if (current.getName().equals(name)){
                found = current;
                return found;
            }
        }
        return found;
    }
    
    public Layer findLayer (String name) {
        Layer found = null;
        for (int i=0;i<countL;i++) {
            Layer current = layers[i];
            if (current.getName().equals(name)){
                found = current;
                return found;
            }
        }
        return found;
    }
    
    /*
    * Setter Methods
    */
    
    public void removePoi (Poi poi) {
        /**
         * Find index of poi to delete
         */
        int index = findPoiIndex(poi.getName());
        if (index == -1){
            System.out.println("Error");
        }
        else {
            pois[index] = null;
        }
        /**
         * create a temporary array to first store POIs that are not null
         * replace the original array with the temporary array
         */
        Poi[] tempPois = new Poi[this.pois.length];
        int count = 0;
        for (int i=0;i<this.pois.length;i++){
            Poi current = pois[i];
            if (current != null) {
                tempPois[count] = current;
                count++;
            }
        }
        this.pois = tempPois;
    }
    
    public void removeLayer (Layer layer) {
        /**
         * Find index of layer to delete
         */
        int index = findLayerIndex(layer.getName());
        if (index == -1){
            System.out.println("Error");
        }
        else {
            layers[index] = null;
        }
        /**
         * create a temporary array to first store Layers that are not null
         * replace the original array with the temporary array
         */
        Layer[] tempLayers = new Layer[this.layers.length];
        int count = 0;
        for (int i=0;i<this.layers.length;i++){
            Layer current = layers[i];
            if (current != null) {
                tempLayers[count] = current;
                count++;
            }
        }
        this.layers = tempLayers;
    }
    
    public void addPoi(Map map, String name, String type, String description, int x, int y, boolean builtIn) {
        Poi newPoi = new Poi (map, name, type, description, x, y, builtIn);
        if (!this.poisIsFull()) {
            pois[countP] = newPoi;
            countP ++;
        }
        else {
            System.out.println("We have reached out limit of: " + MAX_POI);
        }
    }
    
    public void addLayer(Map map, String name, String description, int roomNumber, int x, int y){
        Layer newLayer = new Layer (map, name, description, roomNumber, x, y);
        if (!this.layersIsFull()) {
            layers[countL] = newLayer;
            countL ++;
        }
        else {
            System.out.println("We have reached out limit of: " + MAX_POI);
        }
    }
    
        public void addPoi(Poi newPoi) {
        if (!this.poisIsFull()) {
            pois[countP] = newPoi;
            countP ++;
        }
        else {
            System.out.println("We have reached out limit of: " + MAX_POI);
        }
    }
    
    public void addLayer(Layer newLayer){
        if (!this.layersIsFull()) {
            layers[countL] = newLayer;
            countL ++;
        }
        else {
            System.out.println("We have reached out limit of: " + MAX_POI);
        }
    }
    
    public void changeName (String name) {
        this.name = name;
    }
    
    /*
    * Help Methods
    */
    
    private boolean layersIsFull () {
        return (countL >= MAX_LAYER);
    }
    
    private boolean poisIsFull () {
        return (countP >= MAX_POI);
    }
    
    private int findPoiIndex (String name) {
        int found = -1;
        for (int i=0;i<countP;i++) {
            Poi current = pois[i];
            if (current.getName().equals(name)){
                found = i;
                return found;
            }
        }
        return found;
    }
    
    private int findLayerIndex (String name) {
        int found = -1;
        for (int i=0;i<countL;i++) {
            Layer current = layers[i];
            if (current.getName().equals(name)){
                found = i;
                return found;
            }
        }
        return found;
    }
    
}
