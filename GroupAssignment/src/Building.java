

public class Building {
    
    /*
    * The Building class represents all three buildings with names and maps. 
    * Administrators could add, edit and change the buildings in the system. 
    * Users could switch the buildings and browsing the map
    */
    
    private String name;
    private String description;
    private Map[] maps;
    private final int MAX_MAP = 5;
    private int count;
    
    public Building (String name, String description) {
        this.name = name;
        this.description = description;
        this.maps = new Map[MAX_MAP];
        this.count = 0;
    }
    
    public Map findMap (String name) {
        Map found = null;
        for (int i=0;i<count;i++) {
            Map current = maps[i];
            if (current.getName().equals(name)){
                found = current;
                return found;
            }
        }
        return found;
    }
    
    public String getName () {
        return this.name;
    }
    
    
    
    public String getDescription () {
        return this.description;
    }
    
    public String showMaps() {
        String allMaps = "";
        for (int i=0; i < count; i++){
            allMaps += maps[i].getName() + "\n";
        }
        return allMaps;
    }
    
    public void removeMap (Map map) {
        /**
         * Find index of layer to delete
         */
        int index = findMapIndex(map.getName());
        if (index == -1){
            System.out.println("Error");
        }
        else {
            maps[index] = null;
        }
        /**
         * create a temporary array to first store Layers that are not null
         * replace the original array with the temporary array
         */
        Map[] tempMaps = new Map[this.maps.length];
        int count = 0;
        for (int i=0;i<this.maps.length;i++){
            Map current = maps[i];
            if (current != null) {
                tempMaps[count] = current;
                count++;
            }
        }
        this.maps = tempMaps;
    }
    
    public void changeName (String name) {
        this.name = name;
    }
    
    public void changeDescription (String description) {
        this.description = description;
    }
    
    public void addMap (Map newMap) {
        if (!this.isFull()) {
            maps[count] = newMap;
            count ++;
        }
        else {
            System.out.println("We have reached out limit of: " + MAX_MAP);
        }
    }
    
    private boolean isFull () {
        return (count == MAX_MAP);
    }
    
    private int findMapIndex (String name) {
        int found = -1;
        for (int i=0;i<count;i++) {
            Map current = maps[i];
            if (current.getName().equals(name)){
                found = i;
                return found;
            }
        }
        return found;
    }    
    
}
