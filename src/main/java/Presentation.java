import java.util.Random;
import java.util.Scanner;

public class Presentation
{
    public int getBoardSize(){
        int boardSize = 0;
        while(boardSize != 3 && boardSize != 10) {
            System.out.println("Choose between 3 or 10");
            Scanner sc = new Scanner(System.in);
            boardSize = sc.nextInt();
        }
        return boardSize;

    }
    public void drawBoard(String[][] figures, int boardSize){
        for(int i=0;i<boardSize;i++){
            System.out.print("|");
            for(int j=0;j<boardSize;j++){
                System.out.print(figures[i][j]+"|");
            }
            System.out.print('\n');
        }
    }
    public String playerSelection(){
        String userInput = " ";
        System.out.println("You can choose starting figure buy inserting x | X | o | O");
        while(!userInput.equals("x") && !userInput.equals("X") && !userInput.equals("o") && !userInput.equals("O") ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Select starting figure : ");
            userInput = sc.next();
        }
        return userInput;
    }
    public boolean gameMode(){
        int userInput = 0;
        boolean isSecondPlayer = false;
        while(userInput != 1 && userInput !=2) {
            System.out.println("Do you have second player ?(1 if yes/2 if no)");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()) {
                userInput = sc.nextInt();
            }
            if (userInput == 1) {
                isSecondPlayer = true;
            }
        }
        return isSecondPlayer;
    }
    public boolean chooseStartingPlayer(){
        int userInput = 0;
        boolean answer = false;
        while(userInput != 1 && userInput !=2) {
            System.out.println("Who is playing first: (1 - you | 2 - computer)");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()) {
                userInput = sc.nextInt();
            }
            if (userInput == 1) {
                answer = true;
            }
        }
        return answer;
    }
    public boolean isCurrentMovePlayerMove(int playerIterator, boolean isPlayerStarting){
            return (playerIterator % 2 == 0) == isPlayerStarting;
    }
    public void move(String[][]figures, int playerIterator,String startingPlayerSymbol, boolean vsComputer, boolean isPlayerStarting) throws InvalidMoveException{
        String[][] board;
        board = figures;
        int column;
        int row;
        Random computerMove = new Random();
        String currentPlayerSymbol = startingPlayerSymbol.toUpperCase();
        if(playerIterator % 2 != 0) {
            if (currentPlayerSymbol.equals("O")) {
                currentPlayerSymbol = "X";
            } else if (currentPlayerSymbol.equals("X")) {
                currentPlayerSymbol = "O";
            }
        }
        System.out.println("Player "+currentPlayerSymbol+" move!");
        if(!isCurrentMovePlayerMove(playerIterator,isPlayerStarting) && vsComputer) {
            column = computerMove.nextInt(board.length);
            row = computerMove.nextInt(board.length);
            while (!board[column][row].equals(" ")){
                column = computerMove.nextInt(board.length);
                row = computerMove.nextInt(board.length);
            }
        }else{
            Scanner sc = new Scanner(System.in);
            column = sc.nextInt();
            row = sc.nextInt();
            if(column < 0 || column > figures.length-1 || row <0 || row >figures.length-1){
                throw new InvalidMoveException("value out of boundaries");
            }
            if(!board[column][row].equals(" ")){
                throw new InvalidMoveException("position is already occupied");
            }
        }
        board[column][row] = currentPlayerSymbol;

    }
    public void victoryMessage(int playerIterator,String figure){
        if(playerIterator % 2 ==0){
            if(figure.equals("X")){
                System.out.println("X won!");
            }else{
                System.out.println("O won!");
            }
        }else{
            if(figure.equals("O")){
                System.out.println("O won!");
            }else{
                System.out.println("X won!");
            }
        }
    }

    public void drawMessage(){
        System.out.println("Its a Draw!");
    }
}
