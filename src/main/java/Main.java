public class Main {
    public static void main(String[] args) {
        Presentation presentation = new Presentation();
        Data data = new Data();
        boolean vsComputer = !presentation.gameMode();
        boolean isPlayerStarting = false;
        if(vsComputer){
            isPlayerStarting = presentation.chooseStartingPlayer();
        }
        int boardSize = presentation.getBoardSize();
        data.setBoardState(data.emptyBoardPopulator(boardSize));
        String figure = presentation.playerSelection();
        boolean victoryCondition = false;
        int playerIterator = 0;
        presentation.drawBoard(data.getBoardState(),boardSize);

        while (!victoryCondition && playerIterator < boardSize*boardSize) {
            try{
                presentation.move(data.getBoardState(), playerIterator, figure, vsComputer, isPlayerStarting);
                presentation.drawBoard(data.getBoardState(),boardSize);
                victoryCondition = data.victoryConditionCheck(data.getBoardState());
            }catch (InvalidMoveException e){
                System.out.println(e.getMessage());
            }
            playerIterator++;
        }
        if(victoryCondition){
            presentation.victoryMessage(playerIterator,figure);
        }else {
            presentation.drawMessage();
        }
    }
}
