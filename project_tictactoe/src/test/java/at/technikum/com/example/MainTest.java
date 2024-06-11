package at.technikum.com.example;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
//*RICHTIGE VERSION

class MainTest {
    @Test
    public void testMainStartsGame() {
        // Redirect standard output to capture printed messages
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the main method
        Main.main(null);

        // Check if the game started message is printed
        assertTrue(outContent.toString().contains("Current Player: X"));

        // Restore standard output
        System.setOut(System.out);
    }

    @Test
    public void testMainCompletesGame() {
        // Redirect standard output to capture printed messages
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the main method
        Main.main(null);

        // Check if the game result message is printed
        assertTrue(outContent.toString().contains("It's a draw!"));

        // Restore standard output
        System.setOut(System.out);
    }
}
