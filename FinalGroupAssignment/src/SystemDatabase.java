
import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * <b>System Database</b>
 * @author Team 12
 */

public class SystemDatabase {

    /*
    * Add remove methods for types
    * ADD METHODS STORE DATA INSIDE OF JSON FILES
    * UPLOAD / DOWNLOAD METHODS
     */
    /* 
   private Map[] sysMaps;
   private Layer[] sysLayers;
   private Poi[] sysPois;
     */
    private Building[] sysBuildings;
    /*
   private int countM;
   private int countL;
   private int countP;
     */
    private int countB;

    /**
     * <b>System Database</b>
     * <p>
     * The database that stores, maintains, and modifies data (information) that pertains to the System's Maps. 
     * The Maps will be stored inside of databases called Buildings. Each map will store layers that define its respective areas. 
     * Maps will also consist of Points of Interest (POIs) that can be user-defined or build-in by the Administrator. 
     * User permissions will determine whether the User or Admin can access the Editing Tool which enables them to modify the data that is stored inside the System Database.
     * </p>
     * @param max_maps
     * @param max_layers
     * @param max_pois
     * @param max_buildings 
     */
    public SystemDatabase(int max_maps, int max_layers, int max_pois, int max_buildings) {
        /*
       this.sysMaps = new Map[max_maps];
       this.sysLayers = new Layer[max_layers];
       this.sysPois = new Poi[max_pois];
         */
        this.sysBuildings = new Building[max_buildings];
        /*
       this.countM = 0;
       this.countL = 0;
       this.countP = 0;
         */
        this.countB = 0;
    }

    public SystemDatabase() {
        /*
       this.sysMaps = new Map[25];
       this.sysLayers = new Layer[250];
       this.sysPois = new Poi[500];
         */
        this.sysBuildings = new Building[10];
        /*
       this.countM = 0;
       this.countL = 0;
       this.countP = 0;
         */
        this.countB = 0;
    }

    
    /**
     * Show all the buildings as an output
     * @return A string list of all the buildings
     */
    public String showBuidings() {
        String show = "";
        for (int i = 0; i < countB; i++) {
            show += sysBuildings[i].getName() + "\n";
        }
        return show;
    }

    public String showMaps(Building buildingname) {
        String show = "";
        Building selected = findBuilding(buildingname);
        if (selected == null) {
            System.out.println("Error");
        } else {
            show = selected.showMaps();
        }

        return show;
    }
    /**
     * Output all of the layers
     * @param buildingname
     * @param map
     * @return A string list of layers
     */
    public String showLayers(Building buildingname, Map map) {
        String show = "";
        Building selectedB = findBuilding(buildingname);
        if (selectedB == null) {
            System.out.println("Error");
        } else {
            Map selectedM = selectedB.findMap(map.getName());
            if (selectedM == null) {
                System.out.println("Error");
            } else {
                show = selectedM.showLayers();
            }
        }
        return show;
    }
    /**
     * Output all of the pois
     * @param buildingname
     * @param map
     * @return A string list of pois
     */
    public String showPois(Building buildingname, Map map) {
        String show = "";
        Building selectedB = findBuilding(buildingname);
        if (selectedB == null) {
            System.out.println("Error");
        } else {
            Map selectedM = selectedB.findMap(map.getName());
            if (selectedM == null) {
                System.out.println("Error");
            } else {
                show = selectedM.showPois();
            }
        }
        return show;
    }

       /**
        * Add a non-existing building 
        * @param newBuilding 
        */
    public void addBuilding(Building newBuilding) {
        if (!this.buildingsIsFull()) {
            sysBuildings[countB] = newBuilding;
            countB++;
        } else {
            System.out.println("Error. Limit reached a maximum of: " + sysBuildings.length);
        }
    }

    /**
     * Add a non-existing map
     * @param building
     * @param newMap 
     */
    public void addMap(Building building, Map newMap) {
        Building selected = findBuilding(building);
        if (selected == null) {
            System.out.println("Error");
        } else {
            selected.addMap(newMap);
        }
    }

    /**
     * Add a new layer
     * @param building
     * @param map
     * @param newLayer 
     */
    public void addLayer(Building building, Map map, Layer newLayer) {
        Building selectedB = findBuilding(building);
        if (selectedB == null) {
            System.out.println("Error");
        } else {
            Map selectedM = selectedB.findMap(map.getName());
            if (selectedM == null) {
                System.out.println("Error");
            } else {
                selectedM.addLayer(newLayer);
            }
        }
    }

    /**
     * Add a new POI
     * @param building
     * @param map
     * @param newPoi 
     */
    public void addPoi(Building building, Map map, Poi newPoi) {
        Building selectedB = findBuilding(building);
        if (selectedB == null) {
            System.out.println("Error");
        } else {
            Map selectedM = selectedB.findMap(map.getName());
            if (selectedM == null) {
                System.out.println("Error");
            } else {
                selectedM.addPoi(newPoi);
            }
        }
    }
    
    /**
     * Find a existing POI
     * @param poiName
     * @param mapCode
     * @param floorNumber
     * @return object of POI
     */
    public Poi getPoi(String poiName, String mapCode, int floorNumber) {
        JSONParser jP = new JSONParser();
        String filename = poiName + ".json";
        Map map = new Map("", null);
        try {
            Object obj = jP.parse(new FileReader("SystemDatabase/Maps/"+mapCode+"/"+floorNumber+"/POIs/" + filename));
            System.out.println("Searching line: SystemDatabase/Maps/"+mapCode+"/"+floorNumber+"/POIs/" + filename);
            JSONObject jsonObject = (JSONObject) obj;
            String type = (String) jsonObject.get("Type");
            String description = (String) jsonObject.get("Description");
            String builtBy = (String) jsonObject.get("Built By");
            boolean builtIn = false;
            if (builtBy.toUpperCase().trim().equals("ADMIN"))
                builtIn = true;
            String xStr = (String) jsonObject.get("x");
            int x = Integer.parseInt(xStr);
            String yStr = (String) jsonObject.get("y");
            int y = Integer.parseInt(yStr);
            String name = (String) jsonObject.get("Name");
            
            //String map = (String) jsonObject.get("Map");
            System.out.println("Found values\nname="+name+" type="+type+" x="+xStr+" y="+yStr+" built by="+builtBy+" description="+description);
            Poi foundPoi = new Poi(null, name, type, description, x, y, builtIn);
            return foundPoi;
            /*
                JSONArray dbArray = (JSONArray) jsonObject.get("User");
                Iterator<String> iterator = dbArray.iterator();
                while (iterator.hasNext()) {
                    
                }
             */

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error: File not found");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("I/O ErrorO");
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Parse Error");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error: unable to locate");
        }
        return null;
        
    }
    
    /**
     * Delete a existing Building 
     * @param selected 
     */
    public void removeBuilding(Building selected) {
        /**
         * Find index of layer to delete
         */
        int index = findBuildingIndex(selected);
        if (index == -1) {
            System.out.println("Error");
        } else {
            sysBuildings[index] = null;
        }
        /**
         * create a temporary array to first store buildings that are not null
         * replace the original array with the temporary array
         */
        Building[] tempSysBuildings = new Building[this.sysBuildings.length];
        int count = 0;
        for (int i = 0; i < this.sysBuildings.length; i++) {
            Building current = sysBuildings[i];
            if (current != null) {
                tempSysBuildings[count] = current;
                count++;
            }
        }
        this.sysBuildings = tempSysBuildings;
    }

    /**
     * Delete a existing Map 
     * @param building
     * @param selectedMap 
     */
    public void removeMap(Building building, Map selectedMap) {
        Building selected = findBuilding(building);
        if (selected == null) {
            System.out.println("Error");
        } else {
            selected.removeMap(selectedMap);
        }
    }
    /**
     * Delete a existing Layer
     * @param building
     * @param map
     * @param selectedLayer 
     */
    public void removeLayer(Building building, Map map, Layer selectedLayer) {
        Building selectedB = findBuilding(building);
        if (selectedB == null) {
            System.out.println("Error");
        } else {
            Map selectedM = selectedB.findMap(map.getName());
            if (selectedM == null) {
                System.out.println("Error");
            } else {
                selectedM.removeLayer(selectedLayer);
            }
        }
    }

    /**
     * Delete a existing POI
     * @param building
     * @param map
     * @param selectedPoi 
     */
    public void removePoi(Building building, Map map, Poi selectedPoi) {
        Building selectedB = findBuilding(building);
        if (selectedB == null) {
            System.out.println("Error");
        } else {
            Map selectedM = selectedB.findMap(map.getName());
            if (selectedM == null) {
                System.out.println("Error");
            } else {
                selectedM.removePoi(selectedPoi);
            }
        }
    }

    /**
     * Searching for a existing building
     * @param name
     * @return found building
     */
    public Building findBuilding(Building name) {
        Building found = null;
        for (int i = 0; i < countB; i++) {
            Building current = sysBuildings[i];
            if (current.getName().equals(name)) {
                found = current;
                return found;
            }
        }
        return found;
    }
    
    /**
     * Check image exists
     * @param location_filename
     * @return false if not exists
     */
    public boolean imgExists (String location_filename) {
     
        JSONParser jP = new JSONParser();
        //String filename = poiName + ".json";
        //Map map = new Map("", null);
        try (FileReader reader = new FileReader(location_filename)){
            return true;
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error: File not found");
            return false;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("I/O ErrorO");
            return false;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error: unable to locate");
            return false;
        }
           
    }

    /**
     * Find a existing building index
     * @param name
     * @return found the building index
     */
    private int findBuildingIndex(Building name) {
        int found = -1;
        for (int i = 0; i < countB; i++) {
            Building current = sysBuildings[i];
            if (current.getName().equals(name)) {
                found = i;
                return found;
            }
        }
        return found;
    }

    private boolean buildingsIsFull() {
        return (countB >= this.sysBuildings.length);
    }

}
