import java.util.Scanner;

public class Presentation
{
    public int boardSize(){
        System.out.println("Choose between 3 or 10");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }
    public String playerSelection(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select starting figure : ");
        return sc.next();
    }
    public void board3X3(String[][] figures){
        System.out.println("|"+figures[0][0]+"|"+figures[1][0]+"|"+figures[2][0]+"|");
        System.out.println("|"+figures[0][1]+"|"+figures[1][1]+"|"+figures[2][1]+"|");
        System.out.println("|"+figures[0][2]+"|"+figures[1][2]+"|"+figures[2][2]+"|");
    }
    public void board10X10(String[][] figures, int boardSize){
        for(int i=0;i<boardSize;i++) {
            System.out.println("|" + figures[0][i] + "|" + figures[1][i] + "|" + figures[2][i] + "|" + figures[3][i] + "|" + figures[4][i] + "|" + figures[5][i] + "|" + figures[6][i] + "|" + figures[7][i] + "|" + figures[8][i] + "|" + figures[9][i] + "|");
        }
    }
    public void move(String[][]figures, int playerIterator,String startingPlayer){
        String[][] board;
        board = figures;
             if(playerIterator % 2 == 0){
                 Scanner sc = new Scanner(System.in);
                 System.out.println("Player 1 move: ");
                 int column = sc.nextInt();
                 int row = sc.nextInt();
                 board[column][row] = startingPlayer.toUpperCase();
             }else{
                 Scanner sc = new Scanner(System.in);
                 System.out.println("Player 2 move: ");
                 int column = sc.nextInt();
                 int row = sc.nextInt();
                 String secondPlayer = null;
                 if(startingPlayer.equals("O") || startingPlayer.equals("o")){
                     secondPlayer = "X";
                 }else if(startingPlayer.equals("X") || startingPlayer.equals("x")){
                     secondPlayer = "O";
                 }
                 board[column][row] = secondPlayer;
             }
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
