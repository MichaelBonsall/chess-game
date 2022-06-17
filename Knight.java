import java.util.ArrayList;

public class Knight extends ChessPiece implements Piece{
    private int xCoord; 
    private int yCoord;
    private char color;

    public ArrayList<String> possibleMoves;
    
    /**
     * Knight constructor. X and Y coordinates will be updated as the Knight is moved. Does not contain error checking as it is never used by the user.
     * 
     * @param x Starting X coordinate
     * @param y Starting y Coordinate
     * @param color Knight color 
     */
    public Knight(int x, int y, char color){
        this.color = color;
        xCoord = x;
        yCoord = y;
    }

    /**
     * Checks possible moves of the selected Knight and adds them to an ArrayList type String. Chess.java uses this to see if a user requested move is valid.
     * 
     * @return ArrayList type String containing all possible moves in format "xCoord: x, yCoord: y"
     */
    public ArrayList<String> checkMoves(){
        possibleMoves = new ArrayList<String>();
        if(xCoord - 2 >= 0 && yCoord + 1 < 8){
            if (ChessBoard.board[xCoord - 2][yCoord + 1] == null){
                possibleMoves.add("xCoord: " + (xCoord - 2) + ",yCoord: " + (yCoord + 1));
            }
            else if (ChessBoard.board[xCoord -2][yCoord + 1].getColor() !=color){
                possibleMoves.add("xCoord: " + (xCoord - 2) + ",yCoord: " + (yCoord + 1));
            }
        }
        if(xCoord - 2 >= 0 && yCoord - 1 >=0){
            if (ChessBoard.board[xCoord - 2][yCoord - 1] == null){
                possibleMoves.add("xCoord: " + (xCoord - 2) + ",yCoord: " + (yCoord - 1));
            }
            else if (ChessBoard.board[xCoord -2][yCoord - 1].getColor()!=color){
                possibleMoves.add("xCoord: " + (xCoord - 2) + ",yCoord: " + (yCoord - 1));
            }
        }
        if(xCoord - 1 >= 0 && yCoord + 2 < 8 ){
            if (ChessBoard.board[xCoord - 1][yCoord + 2] == null){
                possibleMoves.add("xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord + 2));
            }
            else if (ChessBoard.board[xCoord - 1][yCoord + 2].getColor()!=color){
                possibleMoves.add("xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord + 2));
            }
        }
        if(xCoord + 1 < 8 && yCoord + 2 < 8 ){
            if (ChessBoard.board[xCoord + 1][yCoord + 2] == null){
                possibleMoves.add("xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord + 2));
            }
            else if (ChessBoard.board[xCoord + 1][yCoord + 2].getColor()!=color){
                possibleMoves.add("xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord + 2));
            }
            
        }
        if(xCoord + 2 < 8 && yCoord + 1 < 8){
            if (ChessBoard.board[xCoord + 2][yCoord + 1] == null){
                possibleMoves.add("xCoord: " + (xCoord +2) + ",yCoord: " + (yCoord + 1));
            }
            else if (ChessBoard.board[xCoord + 2][yCoord + 1].getColor()!=color){
                possibleMoves.add("xCoord: " + (xCoord +2) + ",yCoord: " + (yCoord + 1));
            }
        }
        if(xCoord + 2 < 8 && yCoord - 1 >= 0){
            if (ChessBoard.board[xCoord + 2][yCoord - 1] == null){
                possibleMoves.add("xCoord: " + (xCoord + 2) + ",yCoord: " + (yCoord - 1));
            }
            else if (ChessBoard.board[xCoord + 2][yCoord - 1].getColor()!=color){
                possibleMoves.add("xCoord: " + (xCoord + 2) + ",yCoord: " + (yCoord - 1));
            }
        }   
        if(xCoord - 1 >= 0 && yCoord - 2 >= 0){
            if (ChessBoard.board[xCoord -1][yCoord - 2] == null){
                possibleMoves.add("xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord - 2));
            }
            else if (ChessBoard.board[xCoord -1][yCoord - 2].getColor()!=color){
                possibleMoves.add("xCoord: " + (xCoord - 1) + ",yCoord: " + (yCoord - 2));
            }
        }
        if(xCoord + 1 < 8 && yCoord - 2 >= 0){
            if (ChessBoard.board[xCoord + 1][yCoord - 2] == null){
                possibleMoves.add("xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord - 2));
            }
        else if (ChessBoard.board[xCoord + 1][yCoord - 2].getColor()!=color){
                possibleMoves.add("xCoord: " + (xCoord + 1) + ",yCoord: " + (yCoord - 2));
            }
        }
        return possibleMoves;
    }
    /**
     * To String method used to print the board
     * 
     * @return KN for "KNight" plus the color of the Knight. w for white, b for black.
     * 
     */
    @Override
    public String toString(){
        return "KN" + color;
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
