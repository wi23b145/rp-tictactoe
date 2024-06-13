package at.technikum.com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoardInitialization() {
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', cells[i][j], "Board should be empty on initialization");
            }
        }
    }

    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0), "Cell (0,0) should be empty");
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Cell (0,0) should not be empty after placing a marker");
    }

    @Test
    public void testPlaceMarker() {
        board.place(1, 1, 'X');
        assertEquals('X', board.getCells()[1][1], "Marker 'X' should be placed at cell (1,1)");
    }

    @Test
    public void testPlaceMarkerOnNonEmptyCell() {
        board.place(1, 1, 'X');
        board.place(1, 1, 'O');
        assertEquals('X', board.getCells()[1][1], "Cell (1,1) should not change after attempting to place a second marker");
    }

    @Test
    public void testIsFull() {
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
        assertTrue(board.isFull(), "Board should be full");
    }

    @Test
    public void testIsNotFull() {
        board.place(0, 0, 'X');
        assertFalse(board.isFull(), "Board should not be full");
    }

    @Test
    public void testClearBoard() {
        board.place(0, 0, 'X');
        board.clear();
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', cells[i][j], "Board should be cleared");
            }
        }
    }
}