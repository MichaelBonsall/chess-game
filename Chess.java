import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Run this class to play.
 * 
 */
public class Chess {
    
    private static ArrayList<ChessPiece> whiteTook = new ArrayList<ChessPiece>();
    private static ArrayList<ChessPiece> blackTook = new ArrayList<ChessPiece>();

    private static boolean WHITE_PRINT_POSSIBLE_MOVES = true;
    private static boolean BLACK_PRINT_POSSIBLE_MOVES = true;

    private static boolean whiteTurn = true;

    public static void main(String[] args) {

        ChessPiece[][] board = ChessBoard.createBoard(); 
        Scanner in = new Scanner(System.in);
        
        System.out.println("Initializing board...");
        ChessBoard.visualize(board);
        System.out.println("Board initialized."); 
        
        while (true){
            System.out.println("White, would you like possible moves to be printed?");
            String input = in.next();
            if (input.toLowerCase().equals("no")){
                WHITE_PRINT_POSSIBLE_MOVES = false;
                break;
            }
            else if (input.toLowerCase().equals("yes")){
                WHITE_PRINT_POSSIBLE_MOVES = true;
                break;
            }
            else{
                System.out.println("Input not recognized. Please try again.");
            }
        }
        while (true){
            System.out.println("Black, would you like possible moves to be printed?");
            String input = in.next();
            if (input.toLowerCase().equals("no")){
                BLACK_PRINT_POSSIBLE_MOVES = false;
                break;
            }
            else if (input.toLowerCase().equals("yes")){
                BLACK_PRINT_POSSIBLE_MOVES = true;
                break;
            }
            else{
                System.out.println("Input not recognized. Please try again.");
            }
        }
        while (true){ //game 
            while (whiteTurn){ //white turn
                System.out.println("It is White's turn. Please select a piece you would like to move. Input as is follows: xCoord yCoord. Ex: 0 1");
                
                int xPos;
                int yPos;

                try{
                    xPos = in.nextInt();
                    yPos = in.nextInt();
                } catch (InputMismatchException x){
                    System.out.println("Input not recognized. Please try again.");
                    in.next();
                    continue;
                }
        
                if (xPos > 8 || xPos < 0){
                    System.out.println("X position is not within the bounds of the board. Choose a number from 0 to 7.");
                    continue;

                }
                else if (yPos > 8 || yPos < 0){
                    System.out.println("Y position is not within the bounds of the board. Choose a number from 0 to 7.");
                    continue; 
                }
                else if (board[xPos][yPos] == null){
                    System.out.println("There is no piece there.");
                    continue;
                }
                else if (board[xPos][yPos].getColor() != 'w' ){
                    System.out.println("This isn't your piece. Choose a white piece.");
                    continue;
                }
                else{
                    while (true){//white move loop
                        System.out.println("Choose a place to move the piece to. Input is as follows: xCoord, yCoord. Ex; 0, 1. Q to select a different piece");
                            
                        ArrayList<String> possibleMovesWhite = board[xPos][yPos].checkMoves();
                        if (possibleMovesWhite.isEmpty()){
                            System.out.println("There is no possible move for this piece. Please select a different piece.");
                            break;
                        }
                        if (WHITE_PRINT_POSSIBLE_MOVES){
                            System.out.println(possibleMovesWhite);
                        }
                       
                        int xCoord; 
                        int yCoord;

                        try{
                            xCoord = in.nextInt();
                            yCoord = in.nextInt();
                        } catch (InputMismatchException x){
                            System.out.println("Input not recognized. Please try again.");
                            in.next();
                            continue;
                        }

                        if (xCoord > 8 ||xCoord< 0){
                            System.out.println("The given X Position is not within the bounds of the board. Please try again.");
                            continue; 
                        }
                        else if (yCoord > 8 || yCoord < 0){
                            System.out.println("The given Y Position is not within the bounds of the board. Please try again.");
                            continue;
                        }
                        else if (xCoord == xPos && yCoord == yPos){
                            System.out.println("That is the same position. Please choose another place to move to.");
                            continue;
                        }
                        else{
                            String location = "xCoord: " + xCoord + ",yCoord: " + yCoord;
                            ChessPiece piece = board[xPos][yPos];
                            ArrayList<String> moves = piece.checkMoves(); 
                            if (moves.indexOf(location) != -1){
                                if (board[xCoord][yCoord] != null){
                                    whiteTook.add(board[xCoord][yCoord]);
                                }
                                board[xCoord][yCoord] = piece;
                                piece.setX(xCoord);
                                piece.setY(yCoord);
                                board[xPos][yPos] = null;

                                whiteTurn = false;

                                if (board[xCoord][yCoord] instanceof Pawn){
                                     if (yCoord == 0){
                                        board[xCoord][yCoord].promotion();
                                    } 
                                        
                                }

                            for (ChessPiece tookPiece: whiteTook){
                                if (tookPiece instanceof King){ 
                                    ChessBoard.visualize(board);
                                    System.out.println("Congratulations White. You are the winner!");
                                    in.close();
                                    Pawn.in.close();
                                    System.exit(0);
                                }
                            }

                            ChessBoard.visualize(board);
                            break;
                            }
                            else{
                                System.out.println("That is not a possible move. Try turning on possible moves.");
                                }
                        }
                    }   
                }
            }
            while (!whiteTurn){ //black turn
                System.out.println("It is Black's turn. Please select a piece you would like to move. Input as is follows: xCoord yCoord. Ex: 0 1");

                int xPos;
                int yPos;

                try{
                    xPos = in.nextInt();
                    yPos = in.nextInt();
                } catch (InputMismatchException x){
                    System.out.println("Input not recognized. Please try again.");
                    in.next();
                    continue;
                }

                if (xPos > 8 || xPos < 0){
                    System.out.println("X position is not within the bounds of the board. Choose a number from 0 to 7.");
                    continue;

                }
                else if (yPos > 8 || yPos < 0){
                    System.out.println("Y position is not within the bounds of the board. Choose a number from 0 to 7."); 
                    continue;
                }
                else if (board[xPos][yPos] == null){
                    System.out.println("There is no piece there.");
                    continue;
                }
                else if (board[xPos][yPos].getColor() != 'b' ){
                    System.out.println("This isn't your piece. Choose a black piece.");
                    continue;
                }
                else{
                    while (true){//black move loop
                        System.out.println("Choose a place to move the piece to. Input is as follows: xCoord, yCoord. Ex; 0, 1. Q to select a different piece");
                         
                        ArrayList<String> possibleMovesBlack = board[xPos][yPos].checkMoves();
                        if (possibleMovesBlack.isEmpty()){
                            System.out.println("There is no possible move for this piece. Please select a different piece.");
                            break;
                        }
                        if (BLACK_PRINT_POSSIBLE_MOVES){
                            System.out.println(possibleMovesBlack);
                        }
                            
                        int xCoord; 
                        int yCoord;

                        try{
                            xCoord = in.nextInt();
                            yCoord = in.nextInt();
                        } catch (InputMismatchException x){
                            System.out.println("Input not recognized. Please try again.");
                            in.next();
                            continue;
                        }
                        
                        
                        if (xCoord > 8 ||xCoord< 0){
                            System.out.println("The given X Position is not within the bounds of the board. Please try again.");
                            continue; 
                        }
                        else if (yCoord > 8 || yCoord < 0){
                            System.out.println("The given Y Position is not within the bounds of the board. Please try again.");
                            continue;
                        }
                        else if (xCoord == xPos && yCoord == yPos){
                            System.out.println("That is the same position. Please choose another place to move to.");
                            continue;
                        }
                        else{
                            String location = "xCoord: " + xCoord + ",yCoord: " + yCoord;
                            ChessPiece piece = board[xPos][yPos];
                            ArrayList<String> moves = piece.checkMoves(); 
                            if (moves.indexOf(location) != -1){
                                if (board[xCoord][yCoord] != null){
                                    blackTook.add(board[xCoord][yCoord]);
                                }
                                board[xCoord][yCoord] = piece;
                                piece.setX(xCoord);
                                piece.setY(yCoord);
                                board[xPos][yPos] = null;

                                whiteTurn = true;

                                if (board[xCoord][yCoord] instanceof Pawn){ 
                                    if (yCoord == 7){
                                        board[xCoord][yCoord].promotion();
                                    }
                                        
                                }

                                for (ChessPiece tookPiece: blackTook){
                                    if (tookPiece instanceof King){ 
                                        ChessBoard.visualize(board);
                                        System.out.println("Congratulations Black. You are the winner!");
                                        in.close();
                                        Pawn.in.close();
                                        System.exit(0);
                                    }
                                }

                                ChessBoard.visualize(board);
                                break;

                            }
                            else{
                                System.out.println("That is not a possible move. Try turning on possible moves.");
                            }
                        }   
                    }
                }
            }
        }
    }
}
