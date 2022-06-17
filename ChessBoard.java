public class ChessBoard {
    public static ChessPiece[][] board;

    /**
     * Creates the board 2D array.
     * 
     * @return 2D array of size 8x8.
     */
    public static ChessPiece[][] createBoard(){
        board = new ChessPiece[8][8]; //initializes 8x8 2d array of type chessPiece
        populate();
        return board;
    }
    /**
     * Populates the starting board in the standard layout.
     * 
     */
    public static void populate(){
        board[0][0] = new Rook(0,0,'b');
        board[1][0] = new Knight(1, 0, 'b');
        board[2][0] = new Bishop(2, 0, 'b');
        board[3][0] = new King(3, 0, 'b');
        board[4][0] = new Queen(4, 0, 'b');
        board[5][0] = new Knight(5, 0, 'b');
        board[6][0] = new Bishop(6, 0, 'b');
        board[7][0] = new Rook(7, 0, 'b');

        board[0][1] = new Pawn(0, 1, 'b');
        board[1][1] = new Pawn(1, 1, 'b'); 
        board[2][1] = new Pawn(2, 1, 'b');
        board[3][1] = new Pawn(3, 1, 'b');
        board[4][1] = new Pawn(4, 1, 'b');
        board[5][1] = new Pawn(5, 1, 'b');
        board[6][1] = new Pawn(6, 1, 'b'); 
        board[7][1] = new Pawn(7, 1, 'b');

        board[0][7] = new Rook(0,7,'w');
        board[1][7] = new Knight(1, 7, 'w');
        board[2][7] = new Bishop(2, 7, 'w');
        board[3][7] = new King(3, 7, 'w');
        board[4][7] = new Queen(4, 7, 'w');
        board[5][7] = new Knight(5, 7, 'w');
        board[6][7] = new Bishop(6, 7, 'w');
        board[7][7] = new Rook(7, 7, 'w');

        board[0][6] = new Pawn(0, 6, 'w');
        board[1][6] = new Pawn(1, 6, 'w');
        board[2][6] = new Pawn(2, 6, 'w');
        board[3][6] = new Pawn(3, 6, 'w');
        board[4][6] = new Pawn(4, 6, 'w');
        board[5][6] = new Pawn(5, 6, 'w');
        board[6][6] = new Pawn(6, 6, 'w');
        board[7][6] = new Pawn(7, 6, 'w');
    }

    /**
     * Prints the chessboard to console
     * 
     * @param chessboard The 2d array of type ChessPiece to be printed
     */
    public static void visualize(ChessPiece[][] chessboard ){ 
        System.out.println("   ---------------------------------");    
        for (int i = 0; i < 8; i++){ 
            System.out.print(i + "  ");              
            for (int j = 0; j < 8; j++){
                if (chessboard[j][i] != null){
                    System.out.print("|" + board[j][i] + "");
                }
                else System.out.print("|   ");
                }
            System.out.println("|");
            System.out.println("   ---------------------------------");
        }
        System.out.println("     0   1   2   3   4   5   6   7 ");
    }
    
}
