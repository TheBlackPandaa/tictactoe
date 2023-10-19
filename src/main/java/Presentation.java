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
        Scanner sc = new Scanner(System.in);
        System.out.println("Select starting figure : ");
        return sc.next();
    }
    public void move(String[][]figures, int playerIterator,String startingPlayerSymbol) throws InvalidMoveException{
        String[][] board;
        board = figures;
        String currentPlayerSymbol = startingPlayerSymbol.toUpperCase();
        if(playerIterator % 2 != 0) {
            if (currentPlayerSymbol.equals("O")) {
                currentPlayerSymbol = "X";
            } else if (currentPlayerSymbol.equals("X")) {
                currentPlayerSymbol = "O";
            }
        }
        System.out.println("Player "+currentPlayerSymbol+" move!");
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        int row = sc.nextInt();
        if(column < 0 || column > figures.length-1 || row <0 || row >figures.length-1){
            throw new InvalidMoveException("value out of boundaries");
        }
        if(!board[column][row].equals(" ")){
            throw new InvalidMoveException("position is already occupied");
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
