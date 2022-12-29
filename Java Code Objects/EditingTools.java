

/*
ADD ADDITIONAL EDITINGS TOOLS FOR MODIFYING CLASSES
ADD TOOLS FOR DELETING USER OR ADMIN ACCOUNT

POI
IF USER AND POI IS NOT BUILT IN ALLOW EDITING
*/

public class EditingTools {

    private boolean access;
    private SystemDatabase sysData;
    private UserDatabase usrData;
    
    public EditingTools (User username, SystemDatabase sysData, UserDatabase usrData) {
        this.sysData = sysData;
        this.usrData = usrData;
        this.access = false;
    }
    
    public EditingTools (Admin adminname, SystemDatabase sysData, UserDatabase usrData) {
        this.sysData = sysData;
        this.usrData = usrData;
        this.access = true;
    }
    
    /*
    Modify Maps
    */
    public void addMap (Building building, Map map) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        sysData.addMap(building, map);
    }
    public void mapName (Map map, String name) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        map.changeName(name);
    }
    public void mapAddPoi (Map map, Poi poi){
        if (!access) {
            System.out.print("No access");
            return;
        }
        map.addPoi(poi);
    }
    public void mapRemovePoi (Map map, Poi poi){
        if (!access) {
            System.out.print("No access");
            return;
        }
        map.removePoi(poi);
    }
    public void mapAddLayer (Map map, Layer layer){
        if (!access) {
            System.out.print("No access");
            return;
        }
        map.addLayer(layer);
    }
    public void mapremoveLayer (Map map, Layer layer){
        if (!access) {
            System.out.print("No access");
            return;
        }
        map.removeLayer(layer);
    }    
    
    /*
    Modify layers
    */
    public void addLayer (Building building, Map map, Layer newLayer) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        sysData.addLayer(building, map, newLayer);
    }
    public void layerName (Layer layer, String name) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        layer.changeName(name);
    }
    public void layerDescription (Layer layer, String description) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        layer.changeDescription(description);
    }
    public void layerCoordinates (Layer layer, int x, int y) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        layer.changeX(x);
        layer.changeY(y);
    }
    public void layerRoomNumber (Layer layer, int rn){
        if (!access) {
            System.out.print("No access");
            return;
        }
        layer.changeRoomNumber(rn);
    }
    
    /*
    Modify Pois
    */
    public void addPoi (Building building, Map map, Poi newPoi) {
        if (!access) {
            // USER
            Poi userPoi = new Poi (map, newPoi.getName(), newPoi.getType(), newPoi.getDescription(), newPoi.xCoordinate(), newPoi.yCoordinate(), false);
            sysData.addPoi(building, map, userPoi);
        }
        else { // ADMIN
            Poi adminPoi = new Poi (map, newPoi.getName(), newPoi.getType(), newPoi.getDescription(), newPoi.xCoordinate(), newPoi.yCoordinate(), true);
            sysData.addPoi(building, map, adminPoi);
        }
    }
    public void poiName (Poi poi, String name) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        poi.changeName(name);
    }
    public void poiDescription(Poi poi, String description){
        if (!access) {
            System.out.print("No access");
            return;
        }
        poi.changeDescription(description);
    }
    public void poiType (Poi poi, String type) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        poi.changeType(type);
    }
    /*
    public void poiBuiltInStatus (Poi poi, boolean status) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        poi.changeBuiltInStatus(status);
    }
    */
    public void poiCoordinates (Poi poi, int x, int y) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        poi.changeX(x);
        poi.changeY(y);
    }
    
    /*
    Modify Buildings
    */
    public void addBuilding (Building building) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        sysData.addBuilding(building);
    }
    public void buildingName (Building building, String name){
        if (!access) {
            System.out.print("No access");
            return;
        }
        building.changeName(name);
    }
    public void buildingDescription (Building building, String description) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        building.changeDescription(description);
    }
    
    /*
    SYSTEM DATABASE
    Remove Methods
    */
    public void removeBuilding (Building selected) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        sysData.removeBuilding(selected);
    }
    
    public void removeMap (Building building, Map map) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        sysData.removeMap(building, map);
    }
    
    public void removePoi (Building building, Map map, Poi selectedPoi) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        sysData.removePoi(building, map, selectedPoi);
    }
    
    public void removeLayer (Building building, Map map, Layer selectedLayer) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        sysData.removeLayer(building, map, selectedLayer);
    }
    
    /*
    Modify Users
    */
    public void addUser (User user) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        usrData.userRegister(user.viewUserName(), user.retrievePassword());
    }
    public void userFirstName (User user, String fn) {
         if (!access) {
            System.out.print("No access");
            return;
        }
        user.changeFirstName(fn);
    }
    public void userPassword (User user, String pw) {
         if (!access) {
            System.out.print("No access");
            return;
        }
        user.changePassword(pw);
    }
    public void userLastName (User user, String ln) {
         if (!access) {
            System.out.print("No access");
            return;
        }
        user.changeLastName(ln);
    }
    public void userEnable (User user, boolean enable){
        if (!access) {
            System.out.print("No access");
            return;
        }    
        if (enable) {
            user.enable();
        }
        else {
            user.disable();
        }
    }
    
    /*
    Modify Admins
    */
    public void addAdmin (Admin admin) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        usrData.adminRegister(admin.viewadminName(), admin.viewAdminPassword());
    }
    public void adminPassword (Admin admin, String pw) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        admin.changeAdminPassword(pw);
    }
    public void adminEnable (Admin admin, boolean enable){
        if (!access) {
            System.out.print("No access");
            return;
        }    
        if (enable) {
            admin.enable();
        }
        else {
            admin.disable();
        }
    }
    /*
    USER DATABASE
    Remove Methods
    */
    public void removeUser (User user){
        if (!access) {
            System.out.print("No access");
            return;
        }
        usrData.removeUser(user);
    }
    
    public void removeAdmin (Admin admin) {
        if (!access) {
            System.out.print("No access");
            return;
        }
        usrData.removeAdmin(admin);
    }
           
}
