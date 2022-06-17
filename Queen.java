import java.util.ArrayList;

public class Queen extends ChessPiece implements Piece {
    private int xCoord; 
    private int yCoord;
    private char color;

    public ArrayList<String> possibleMoves;

    /**
     * Queen constructor. X and Y coordinates will be updated as the Queen is moved. Does not contain error checking as it is never used by the user.
     * 
     * @param x Starting X coordinate
     * @param y Starting y Coordinate
     * @param color Queen color 
     */
    public Queen(int x, int y, char color){
        this.color = color;
        xCoord = x;
        yCoord = y;
    }
    /**
     * Checks possible moves and adds them to an ArrayList type String. Chess.java uses this to see if a user requested move is valid.
     * 
     * @return ArrayList type String containing all possible moves in format "xCoord: x, yCoord: y"
     */
    public ArrayList<String> checkMoves(){
        possibleMoves = new ArrayList<String>();
        //north
        int j = 1;
        while (yCoord  - j >= 0 ){
            if (ChessBoard.board[xCoord][yCoord - j] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + xCoord + ",yCoord: " + (yCoord - j));
                j++;
            }
            else if (ChessBoard.board[xCoord][yCoord - j] != null){
                if (ChessBoard.board[xCoord][yCoord - j].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + xCoord + ",yCoord: " + (yCoord - j));
                    break;
                }
                else break;
            }

        }
        //south
        j = 1;
        while (yCoord  + j < 8 ){
            if (ChessBoard.board[xCoord][yCoord + j] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + xCoord + ",yCoord: " + (yCoord + j));
                j++;
            }
            else if (ChessBoard.board[xCoord][yCoord + j] != null){
                if (ChessBoard.board[xCoord][yCoord + j].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + xCoord + ",yCoord: " + (yCoord + j));
                    break;
                }
                else break;
            }
        }
        //east
        j = 1;
        while (xCoord  + j < 8 ){
            if (ChessBoard.board[xCoord + j][yCoord] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + (xCoord + j) + ",yCoord: " + yCoord);
                j++;
            }
            else if (ChessBoard.board[xCoord + j][yCoord] != null){
                if (ChessBoard.board[xCoord + j][yCoord].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + (xCoord + j) + ",yCoord: " + yCoord);
                    break;
                }
                else break;
            }
        }
        //west
        j = 1;
        while (xCoord  - j >= 0 ){
            if (ChessBoard.board[xCoord - j][yCoord] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + (xCoord - j) + ",yCoord: " + yCoord);
                j++;
            }
            else if (ChessBoard.board[xCoord - j][yCoord] != null){
                if (ChessBoard.board[xCoord - j][yCoord].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + (xCoord - j) + ",yCoord: " + yCoord);
                    break;
                }
                else break;
            }
        }
        int i = 1;
        while (xCoord  - i >= 0 && yCoord - i >= 0){ //northwest
            if (ChessBoard.board[xCoord - i][yCoord - i] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + (xCoord - i) + ",yCoord: " + (yCoord - i));
                i++;
                
            }
            else if (ChessBoard.board[xCoord - i][yCoord - i] != null){ 
                if (ChessBoard.board[xCoord - i][yCoord - i].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + (xCoord - i) + ",yCoord: " + (yCoord - i));
                    break;
                }
                else break;
            }
        }
        i = 1;
        while (xCoord - i >= 0 && yCoord + i < 8){ //southwest
            if (ChessBoard.board[xCoord - i][yCoord + i] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + (xCoord - i) + ",yCoord: " + (yCoord + i));
                i++;
            }
            else if (ChessBoard.board[xCoord - i][yCoord + i] != null){
                if (ChessBoard.board[xCoord - i][yCoord + i].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + (xCoord - i) + ",yCoord: " + (yCoord + i));
                    break;
                }
                else break;
            }
        }
        i = 1;
        while (xCoord + i < 8 && yCoord - i >= 0){ //northeast
            if (ChessBoard.board[xCoord + i][yCoord - i] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + (xCoord + i) + ",yCoord: " + (yCoord - i));
                i++;
            }
            else if (ChessBoard.board[xCoord + i][yCoord - i] != null){ 
                if (ChessBoard.board[xCoord + i][yCoord - i].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + (xCoord + i) + ",yCoord: " + (yCoord - i));
                    break;
                }
                else break;
            }
        }
        i = 1;
        while (xCoord  + i < 8 && yCoord + i < 8){ //southeast
            if (ChessBoard.board[xCoord + i][yCoord + i] == null){ //if its in bounds and if no other piece is there
                possibleMoves.add("xCoord: " + (xCoord + i) + ",yCoord: " + (yCoord + i));
                i++;
            }
            else if (ChessBoard.board[xCoord + i][yCoord + i] != null){
                if (ChessBoard.board[xCoord + i][yCoord + i].getColor() != color){ //different color, take
                    possibleMoves.add("xCoord: " + (xCoord + i) + ",yCoord: " + (yCoord + i));
                    break;
                }
                else break;
            }
        }
        return possibleMoves;
    }

    /**
     * To String method used to print the board
     * 
     * @return "Q" for "Queen" plus the color of the Queen. w for white, b for black
     * 
     */
    @Override
    public String toString(){
        return " Q" + color;
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
