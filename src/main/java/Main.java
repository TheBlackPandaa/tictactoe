public class Main {
    public static void main(String[] args) {
        Presentation presentation = new Presentation();
        Data data = new Data();
        int boardSize = presentation.boardSize();
        data.setBoardState(data.emptyBoardPopulator(boardSize));
        String figure = presentation.playerSelection();
        boolean victoryCondition = false;
        int playerIterator = 0;
        if(boardSize == 3) {
            presentation.board3X3(data.getBoardState());
            while (!victoryCondition && playerIterator < 9) {
                presentation.move(data.getBoardState(), playerIterator, figure);
                presentation.board3X3(data.getBoardState());
                victoryCondition = data.victoryCondition3X3(data.getBoardState());
                playerIterator++;
            }
        }
        if(boardSize == 10) {
            presentation.board10X10(data.getBoardState(),boardSize);
            while (!victoryCondition && playerIterator < 99) {
                presentation.move(data.getBoardState(), playerIterator, figure);
                presentation.board10X10(data.getBoardState(), boardSize);
                victoryCondition = data.victoryCondition10X10(data.getBoardState());
                playerIterator++;
            }
        }
        if(victoryCondition){
            presentation.victoryMessage(playerIterator,figure);
        }else {
            presentation.drawMessage();
        }
    }
}
