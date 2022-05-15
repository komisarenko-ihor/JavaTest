package javatest.statistics;

import javatest.printer.ConsoleStatisticsPrinter;
import javatest.reader.SimpleCharacterReader;
import javatest.statistic.SimpleCharacterReaderStatistics;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class SimpleCharacterReaderStatisticsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    SimpleCharacterReaderStatistics statistics = new SimpleCharacterReaderStatistics(
            new SimpleCharacterReader(),
            new ConsoleStatisticsPrinter());

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
        statistics.printStatistics();

        assertTrue(outContent.size() > 0);
    }
}