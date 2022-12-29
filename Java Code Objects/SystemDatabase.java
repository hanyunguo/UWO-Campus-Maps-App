
import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public void addBuilding(Building newBuilding) {
        if (!this.buildingsIsFull()) {
            sysBuildings[countB] = newBuilding;
            countB++;
        } else {
            System.out.println("Error. Limit reached a maximum of: " + sysBuildings.length);
        }
    }

    public void addMap(Building building, Map newMap) {
        Building selected = findBuilding(building);
        if (selected == null) {
            System.out.println("Error");
        } else {
            selected.addMap(newMap);
        }
    }

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

    public void removeMap(Building building, Map selectedMap) {
        Building selected = findBuilding(building);
        if (selected == null) {
            System.out.println("Error");
        } else {
            selected.removeMap(selectedMap);
        }
    }

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
