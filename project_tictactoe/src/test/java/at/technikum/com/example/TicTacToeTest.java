package at.technikum.com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe game;
    private Board board;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
        board = new Board();
    }

    @Test
    public void testSwitchCurrentPlayer() {
        Player currentPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotEquals(currentPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testHasWinnerRow() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerColumn() {
        board.place(0, 0, 'O');
        board.place(1, 0, 'O');
        board.place(2, 0, 'O');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerDiagonal() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testNoWinner() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'X');
        board.place(1, 1, 'O');
        board.place(1, 2, 'X');
        board.place(2, 0, 'O');
        board.place(2, 1, 'X');
        board.place(2, 2, 'O');
        assertFalse(game.hasWinner());
    }

    @Test
    public void testMakeMoveValid() {
        game.makeMove(0, 0); // assume this method has been changed to take parameters for testing
        assertEquals('X', board.getCells()[0][0]);
    }

    @Test
    public void testMakeMoveInvalid() {
        game.makeMove(0, 0); // place X
        assertThrows(IllegalArgumentException.class, () -> {
            game.makeMove(0, 0); // attempt to place O in the same cell
        });
    }

    @Test
    public void testBoardIsFull() {
        // Fill the board
        char[][] moves = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, moves[i][j]);
            }
        }
        assertTrue(board.isFull());
    }
}