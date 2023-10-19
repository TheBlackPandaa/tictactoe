public class Main {
    public static void main(String[] args) {
        Presentation presentation = new Presentation();
        Data data = new Data();
        int boardSize = presentation.getBoardSize();
        data.setBoardState(data.emptyBoardPopulator(boardSize));
        String figure = presentation.playerSelection();
        boolean victoryCondition = false;
        int playerIterator = 0;
        presentation.drawBoard(data.getBoardState(),boardSize);
        while (!victoryCondition && playerIterator < boardSize*boardSize) {
            try{
                presentation.move(data.getBoardState(), playerIterator, figure);
                presentation.drawBoard(data.getBoardState(),boardSize);
                victoryCondition = data.victoryConditionCheck(data.getBoardState());
                playerIterator++;
            }catch (InvalidMoveException e){
                System.out.println(e.getMessage());
            }
        }
        if(victoryCondition){
            presentation.victoryMessage(playerIterator,figure);
        }else {
            presentation.drawMessage();
        }
    }
}
