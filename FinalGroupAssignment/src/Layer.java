/**
 * <b>Layer</b>
 * <p>
 * The Layer class has all the method for layers
 * </p>
 * @author Team 12
 */

public class Layer {
    
    /**
     * Instance Variables
     */
    private String name;
    private String description;
    private Coordinates coordinate;
    private int roomNumber;
    private Map assignedMap;
    
    

    /**
     * Layer Constructors
     * @param map
     * @param name
     * @param description
     * @param roomNumber
     * @param x
     * @param y 
     */
    public Layer (Map map, String name, String description, int roomNumber, int x, int y) {
        this.name = name;
        this.description = description;
        this.roomNumber = roomNumber;
        this.coordinate = new Coordinates (x, y);
        this.assignedMap = map;
    }

    /**
     * Getters
     * @return the name, description, room number, x y coordinate
     */
    public String getName () {
        return this.name;
    }
    
    public String getDescription () {
        return this.description;
    }
    
    public int getRoomNumber () {
        return this.roomNumber;
    }
    
   public int xCoordinate () {
       return this.coordinate.getX();
   }
   
   public int yCoordinate () {
       return this.coordinate.getY();
   }
    

   /**
    * Setters method
    * @param name 
    */
   public void changeName (String name) {
       this.name = name;
   }
   
   public void changeDescription (String description) {
       this.description = description;
   }
   
   public void changeX (int x) {
       this.coordinate.changeX(x);
   }
   
   public void changeY (int y) {
       this.coordinate.changeY(y);
   }
   
   public void changeRoomNumber (int roomNumber) {
       this.roomNumber = roomNumber;
   }
    
    /*Helpers*/

}
