import java.util.ArrayList;

public class King extends ChessPiece implements Piece {
    private int xCoord; 
    private int yCoord;
    private char color; 
    
    public ArrayList<String> possibleMoves;
    
    /**
     * King constructor. X and Y coordinates will be updated as the King is moved. Does not contain error checking as it is never used by the user.
     * 
     * @param x Starting X coordinate
     * @param y Starting y Coordinate
     * @param color King color 
     */
    public King(int x, int y, char color){ 
        this.color = color;
        xCoord = x;
        yCoord = y; 
    }

    /**
     * Checks possible moves and adds them to an ArrayList type String. Chess.java uses this to see if a user requested move is valid.
     * 
     * @return ArrayList type String containing all possible moves in format "xCoord: x, yCoord: y"
     */

    //Not checked.
    public ArrayList<String> checkMoves(){ 
        possibleMoves = new ArrayList<String>(); 
        
        if (yCoord - 1 >= 0){//north move possible          
            if (ChessBoard.board[xCoord][yCoord - 1] == null){
                possibleMoves.add( "xCoord: " + xCoord + ",yCoord: " + (yCoord - 1));
            }
            else if (ChessBoard.board[xCoord][yCoord - 1].getColor() != color){
                possibleMoves.add( "xCoord: " + xCoord + ",yCoord: " + (yCoord - 1));
            }
        } 
        if (yCoord + 1 < 8){ //south move possible
            if (ChessBoard.board[xCoord][yCoord + 1] == null){
                possibleMoves.add( "xCoord: " + xCoord + ",yCoord: " + (yCoord + 1));
            }
            else if (ChessBoard.board[xCoord][yCoord - 1].getColor() != color){
                possibleMoves.add( "xCoord: " + xCoord + ",yCoord: " + (yCoord + 1));
            }
        } 
        if (xCoord + 1 < 8){ //east move possible
            if (ChessBoard.board[xCoord + 1][yCoord] == null){
                possibleMoves.add( "xCoord: " + (xCoord + 1) + ",yCoord: " + yCoord);
            }
            else if (ChessBoard.board[xCoord + 1][yCoord].getColor() != color){
                possibleMoves.add( "xCoord: " + (xCoord + 1) + ",yCoord: " + yCoord);
            }
        }
        if (xCoord - 1 >= 0){ //west move possible
            if (ChessBoard.board[xCoord + 1][yCoord] == null){
                possibleMoves.add( "xCoord: " + (xCoord - 1) + ",yCoord: " + yCoord);
            }
            else if (ChessBoard.board[xCoord + 1][yCoord].getColor() != color){
                possibleMoves.add( "xCoord: " + (xCoord + 1) + ",yCoord: " + yCoord);
            }
        }
        if ((xCoord + 1 < 8)  && (yCoord + 1 < 8)){ //southeast move possible
            if (ChessBoard.board[xCoord + 1][yCoord  + 1] == null){
                possibleMoves.add( "xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord + 1));
            }
            else if (ChessBoard.board[xCoord + 1][yCoord + 1].getColor() != color){
                possibleMoves.add( "xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord + 1));
            }
        }
        if ((xCoord - 1 >= 0)  && (yCoord + 1 < 8)){ //southwest move possible
            if (ChessBoard.board[xCoord - 1][yCoord  + 1] == null){
                possibleMoves.add( "xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord + 1));
            }
            else if (ChessBoard.board[xCoord - 1][yCoord + 1].getColor() != color){
                possibleMoves.add( "xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord + 1));
            }
        }
        if ((xCoord + 1 < 8)  && (yCoord - 1 >= 0)){ //northeast move possible
            if (ChessBoard.board[xCoord + 1][yCoord  - 1] == null){
                possibleMoves.add( "xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord - 1));
            }
            else if (ChessBoard.board[xCoord + 1][yCoord - 1].getColor() != color){
                possibleMoves.add( "xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord - 1));
            }
        }
        if ((xCoord - 1 >= 0)  && (yCoord - 1 >= 0)){ //northwest move possible
            if (ChessBoard.board[xCoord - 1][yCoord  - 1] == null){
                possibleMoves.add( "xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord - 1));
            }
            else if (ChessBoard.board[xCoord - 1][yCoord - 1].getColor() != color){
                possibleMoves.add( "xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord - 1));
            }
        } 

        return possibleMoves;
    }
    
    /**
     * To String method used to print the board
     * 
     * @return "K" for "King" plus the color of the King. w for white, b for black
     */
    @Override
    public String toString(){
        return " K" + color;
    }

    /**
     * Color getter
     * 
     * @return The color of the designated piece.
     */
    public char getColor(){
        return color; 
    }

    /**
     * X coordinate setter
     * 
     * @param x The new X coordinate after the move
     */
    public void setX(int x){
        xCoord = x;
    }

    /**
     *  Y coordinate setter
     * 
     * @param y The new Y coordinate after the move
     */
    public void setY(int y){
        yCoord = y;
    }
}
