package at.technikum.com.example;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

        private TicTacToe game;

        @BeforeEach
        public void setUp() {
            game = new TicTacToe();
        }

        @Test
        public void testSwitchCurrentPlayer() {
            Player initialPlayer = game.getCurrentPlayer();
            game.switchCurrentPlayer();
            assertNotEquals(initialPlayer, game.getCurrentPlayer());
        }

        @Test
        public void testHasWinner() {
            game.getBoard().place(0, 0, 'X');
            game.getBoard().place(0, 1, 'X');
            game.getBoard().place(0, 2, 'X');
            assertTrue(game.hasWinner());
        }

        @Test
        public void testMakeMove() {
            game.makeMove(new int[]{0, 0});
            assertEquals('X', game.getBoard().getCells()[0][0]);
            game.switchCurrentPlayer();
            game.makeMove(new int[]{1, 1});
            assertEquals('O', game.getBoard().getCells()[1][1]);
        }
    }







