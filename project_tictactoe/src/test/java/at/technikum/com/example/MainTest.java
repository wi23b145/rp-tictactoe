package at.technikum.com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



class MainTest {




        @Test
        public void testMain() {
            String[] args = {};
            Main.main(args);
            assertTrue(true); // If no exception is thrown, the test passes.
        }
    }



