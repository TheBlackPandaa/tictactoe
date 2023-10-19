public class Data {
    private String[][] boardState;

    public void setBoardState(String[][] boardState) {
        this.boardState = boardState;
    }
    public String[][] getBoardState() {
        return boardState;
    }

    public String[][] emptyBoardPopulator(int size){
        String[][] emptyBoard = new String[size][size];
        for(int i=0 ; i<size ; i++){
            for(int j=0 ; j<size ; j++){
                emptyBoard[i][j]=" ";
            }
        }
        return emptyBoard;
    }

    public boolean victoryCondition3X3(String[][] boardState) {
        boolean victory = false;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                String figureCheck = boardState[i][j];
                if (figureCheck.equals("X")||figureCheck.equals("O")) {
                    if(i==0 && j==0) {
                        if (boardState[i + 1][j + 1].equals(figureCheck) && boardState[i + 2][j + 2].equals(figureCheck)) {
                            victory = true;
                        }
                    }
                    if(j==0){
                            if(boardState[i][j + 1].equals(figureCheck) && boardState[i][j + 2].equals(figureCheck)) {
                            victory = true;
                        }
                    }
                    if (i==0) {
                        if (boardState[i + 1][j].equals(figureCheck) && boardState[i + 2][j].equals(figureCheck)) {
                            victory = true;
                        }
                    }
                    if(i == 2 && j == 0) {
                        if (boardState[i - 1][j + 1].equals(figureCheck) && boardState[i - 2][j + 2].equals(figureCheck)) {
                            victory = true;
                        }
                    }
                }
            }
        }
        return victory;
    }
    public boolean victoryCondition10X10(String[][] boardState) {
        boolean victory = false;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++) {
                String figureCheck = boardState[i][j];
                if (figureCheck.equals("X")||figureCheck.equals("O")) {
                    if(i<5 && j<5) {
                        if (boardState[i + 1][j + 1].equals(figureCheck) && boardState[i + 2][j + 2].equals(figureCheck)&& boardState[i + 3][j + 3].equals(figureCheck)&& boardState[i + 4][j + 4].equals(figureCheck)) {
                            victory = true;
                            break;
                        }
                    }
                    if(j<5){
                        if(boardState[i][j + 1].equals(figureCheck) && boardState[i][j + 2].equals(figureCheck) && boardState[i][j + 3].equals(figureCheck) && boardState[i][j + 4].equals(figureCheck)) {
                            victory = true;
                        }
                        break;
                    }
                    if (i<5) {
                        if (boardState[i + 1][j].equals(figureCheck) && boardState[i + 2][j].equals(figureCheck) && boardState[i + 3][j].equals(figureCheck) && boardState[i + 4][j].equals(figureCheck)) {
                            victory = true;
                        }
                        break;
                    }
                    if(i > 4 && j < 6 ) {
                        if (boardState[i - 1][j + 1].equals(figureCheck) && boardState[i - 2][j + 2].equals(figureCheck) && boardState[i - 3][j + 3].equals(figureCheck) && boardState[i - 4][j + 4].equals(figureCheck)) {
                            victory = true;
                        }
                        break;
                    }
                }
            }
        }
        return victory;
    }
}
