import java.util.ArrayList;

/**
* Parent class to extend piece types. No constructor as every object should be the specific piece.
* 
*/
public class ChessPiece {

    public int xCoord;
    public int yCoord;

    /**
     * Color getter. This will never be called but it is needed for the child classes to work.
     * 
     * @return 'f'.
     */
    public char getColor(){ 
        return 'f';
    }

    /**
     * Parent method for checkMoves(). 
     * 
     * @return ArrayList type String containing all possible moves in format "xCoord: x, yCoord: y"
     */
    public ArrayList<String> checkMoves(){
        return new ArrayList<String>();
    }
    /**
     * X coordinate setter. Parent method for setX();
     * 
     * @param x The new X coordinate after the move
     */
    public void setX(int x){
        xCoord = x;
    }

    /**
     *  Y coordinate setter. Parent method for setY();
     * 
     * @param y The new Y coordinate after the move
     */
    public void setY(int y){
        yCoord = y;
    }

    public void promotion() { //Here bc I think its needed for promotion to work. Needs testing.
    }
}
