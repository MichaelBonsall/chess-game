import java.util.ArrayList;

public interface Piece {
    /**
     * Returns an array list of all possible moves for the selected piece.
     * 
     * @return ArrayList type String of all possible moves. Format is "xCoord: x, yCoord: y".
     */
    ArrayList<String> checkMoves();

    /**
     * 
     * Returns the color of the selected piece. w for white, b for black.
     * 
     * @return color of the piece
     */
    char getColor();

    /**
     * toString method to print the chesspiece object.
     * 
     * @return The first one or two letters of the piece, plus the color.
     */
    String toString();

    /**
     * X coordinate setter
     * 
     * @param X the new X coordinate of the piece
     */
    void setX(int X);

    /**
     * Y coordinate setter
     * 
     * @param Y the new Y coordinate of the piece
     */
    void setY(int Y);
}
