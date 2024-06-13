package at.technikum.com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testPlayerCreation() {
        Player player = new Player("Alice", 'x');
        assertEquals("Alice", player.getName());
        assertEquals('x', player.getMark());
    }

    @Test
    void testPlayerMark() {
        Player player = new Player("Bob", 'o');
        assertEquals('o', player.getMark());
    }
}