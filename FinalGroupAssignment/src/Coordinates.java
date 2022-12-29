

/**
 * <b>Coordinates</b>
 * <p>
 * The coordinate class uses for all the Coordinates for POIS
 * </p>
 * @author Team 12
 */

public class Coordinates {

    private int x;
    private int y;
    
    public Coordinates (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX () {
        return this.x;
    }
    
    public int getY () {
        return this.y;
    }
    
    public void changeX (int newX){
        this.x=newX;
    }
        
    public void changeY (int newY){
        this.x=newY;
    }
}
