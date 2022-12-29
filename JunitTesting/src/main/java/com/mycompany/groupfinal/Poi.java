package com.mycompany.groupfinal;



public class Poi {

    private boolean isFavourite;
    private String name;
    private Coordinates coordinate;
    private String description;
    private String type;
    private boolean builtIn;
    private Map assignedMap;
    
    
   public Poi (Map map, String name, String type, String description, int x, int y, boolean builtIn) {
       this.name = name;
       this.type = type;
       this.coordinate = new Coordinates (x, y);
       this.builtIn = builtIn;
       this.assignedMap = map;
       this.description = description;
   }
   
   /*Getters*/
   
   public String getName() {
       return this.name;
   }
   
   public String getType() {
       return this.type;
   }
   
   public String getDescription() {
       return this.description;
   }
   
   public int xCoordinate () {
       return this.coordinate.getX();
   }
   
   public int yCoordinate () {
       return this.coordinate.getY();
   }
   
   public boolean isBuiltIn () {
       return this.builtIn;
   }
   
   /*Setters*/
   public void changeName (String newName) {
       this.name = newName;
   }
   
   public void changeType (String newType) {
       this.type = newType;
   }
   
   public void changeDescription (String newDescription) {
       this.description = newDescription;
   }
   
   public void changeX (int x) {
       this.coordinate.changeX(x);
   }
   
   public void changeY (int y) {
       this.coordinate.changeY(y);
   }
   
   public void changeBuiltInStatus (boolean updatedStatus) {
       this.builtIn = updatedStatus;
   }
   
   /*Helpers*/
}
