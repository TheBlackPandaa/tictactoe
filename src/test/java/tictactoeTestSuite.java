import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("tic tac toe tests")
public class tictactoeTestSuite {
@Nested
@DisplayName("Tests for O wins")
class TestsForO {
    @Test
    @DisplayName("Three O in a row")
    void threeOInARow() {
        //given
        Data data = new Data();
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        board[0][0] = "O";
        board[0][1] = "O";
        board[0][2] = "O";
        data.setBoardState(board);
        boolean vc;
        //when
        vc = data.victoryConditionCheck(data.getBoardState());
        //
        Assertions.assertTrue(vc);
    }

    @Test
    @DisplayName("Three O in a columns")
    void threeOInAColumn() {
        //given
        Data data = new Data();
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        board[0][0] = "O";
        board[1][0] = "O";
        board[2][0] = "O";
        data.setBoardState(board);
        boolean vc;
        //when
        vc = data.victoryConditionCheck(data.getBoardState());
        //
        Assertions.assertTrue(vc);
    }

    @Test
    @DisplayName("O diagonal going down")
    void threeOInDiagonalDown() {
        //given
        Data data = new Data();
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        board[0][0] = "O";
        board[1][1] = "O";
        board[2][2] = "O";
        data.setBoardState(board);
        boolean vc;
        //when
        vc = data.victoryConditionCheck(data.getBoardState());
        //
        Assertions.assertTrue(vc);
    }

    @Test
    @DisplayName("O diagonal going up")
    void threeOInDiagonalUp() {
        //given
        Data data = new Data();
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        board[2][0] = "O";
        board[1][1] = "O";
        board[0][2] = "O";
        data.setBoardState(board);
        boolean vc;
        //when
        vc = data.victoryConditionCheck(data.getBoardState());
        //
        Assertions.assertTrue(vc);
    }
}
    @Nested
    @DisplayName("Test for X win")
    class TestsForX{
        @Test
        @DisplayName("Three X in a row")
        void threeXInARow() {
            //given
            Data data = new Data();
            String[][] board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = " ";
                }
            }
            board[0][0] = "X";
            board[0][1] = "X";
            board[0][2] = "X";
            data.setBoardState(board);
            boolean vc;
            //when
            vc = data.victoryConditionCheck(data.getBoardState());
            //
            Assertions.assertTrue(vc);
        }

        @Test
        @DisplayName("Three X in a columns")
        void threeXInAColumn() {
            //given
            Data data = new Data();
            String[][] board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = " ";
                }
            }
            board[0][0] = "X";
            board[1][0] = "X";
            board[2][0] = "X";
            data.setBoardState(board);
            boolean vc;
            //when
            vc = data.victoryConditionCheck(data.getBoardState());
            //
            Assertions.assertTrue(vc);
        }

        @Test
        @DisplayName("X diagonal going down")
        void threeXInDiagonalDown() {
            //given
            Data data = new Data();
            String[][] board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = " ";
                }
            }
            board[0][0] = "X";
            board[1][1] = "X";
            board[2][2] = "X";
            data.setBoardState(board);
            boolean vc;
            //when
            vc = data.victoryConditionCheck(data.getBoardState());
            //
            Assertions.assertTrue(vc);
        }

        @Test
        @DisplayName("X diagonal going up")
        void threeXInDiagonalUp() {
            //given
            Data data = new Data();
            String[][] board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = " ";
                }
            }
            board[2][0] = "X";
            board[1][1] = "X";
            board[0][2] = "X";
            data.setBoardState(board);
            boolean vc;
            //when
            vc = data.victoryConditionCheck(data.getBoardState());
            //
            Assertions.assertTrue(vc);
        }

    }
    @Nested
    @DisplayName("InputTests")
    class inputTests{
        @Test
        @DisplayName("Input ot of boundaries test")
            void inputOutOfBoundariesTest(){
                //given
                Presentation presentation = new Presentation();
                String[][] board = new String[10][10];
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        board[i][j] = " ";
                    }
                }
                String input ="0 14";
                InputStream is = new ByteArrayInputStream(input.getBytes());
                System.setIn(is);
                //When&Then
                assertThrows(InvalidMoveException.class, () ->presentation.move(board,0,"X"));
            }
        @Test
        @DisplayName("Occupied Field test")
        void occupiedFieldTest(){
            //given
            Presentation presentation = new Presentation();
            String[][] board = new String[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    board[i][j] = " ";
                }
            }
            board[0][9] = "X";
            String input ="0 9";
            InputStream is = new ByteArrayInputStream(input.getBytes());
            System.setIn(is);
            //When&Then
            assertThrows(InvalidMoveException.class, () ->presentation.move(board,1,"X"));
        }
    }
}
