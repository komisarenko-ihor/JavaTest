package javatest.printer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ConsoleStatisticsPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void PrintCharacterReaderStatistics() {
        StatisticsPrinter printer = new ConsoleStatisticsPrinter();
        printer.print(Map.of("B", 1L, "C", 2L, "A", 2L));

        assertTrue(outContent.toString().startsWith("A - 2\r\nC - 2\r\nB - 1\r\n"));
    }
}