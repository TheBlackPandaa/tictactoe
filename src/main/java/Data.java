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
    public boolean victoryConditionCheck(String[][] boardState) {
        int boardSize = boardState.length;
        int required = (boardSize == 3) ? 3 : 5;
        boolean victory = false;
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                String figureCheck = boardState[i][j];
                if (figureCheck.equals("X")||figureCheck.equals("O")) {
                    if(i<=boardSize-required && j<=boardSize-required) {
                        for(int k=1;k<required;k++){
                            if(boardState[i + k][j + k].equals(figureCheck)){
                                if(k == required-1){
                                    victory = true;
                                }
                            }else{
                                break;
                            }
                        }
                    }
                    if(j<=boardSize-required){
                        for(int k=1;k<required;k++){
                            if(boardState[i][j + k].equals(figureCheck)){
                                if(k == required-1){
                                    victory = true;
                                }
                            }else{
                                break;
                            }
                        }
                    }
                    if (i<=boardSize-required) {
                        for(int k=1;k<required;k++){
                            if(boardState[i + k][j].equals(figureCheck)){
                                if(k == required-1){
                                    victory = true;
                                }
                            }else{
                                break;
                            }
                        }
                    }
                    if(i >= required - 1 && j <= boardSize-required ) {
                        for(int k=1;k<required;k++){
                            if(boardState[i - k][j + k].equals(figureCheck)){
                                if(k == required-1){
                                    victory = true;
                                }
                            }else{
                                break;
                            }
                        }
                    }
                }
                if(victory) break;
            }
            if(victory) break;
        }
        return victory;
    }
}
