package javatest.statistics;

import javatest.printer.ConsoleStatisticsPrinter;
import javatest.reader.SlowCharacterReader;
import javatest.statistic.SlowCharacterReaderStatistics;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SlowCharacterReaderStatisticsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private SlowCharacterReaderStatistics statistics =
            new SlowCharacterReaderStatistics(
                    List.of(new SlowCharacterReader(), new SlowCharacterReader()), new ConsoleStatisticsPrinter());

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void ShouldGenerateFrequenciesAndPrint() {
        statistics.printStatistics();

        assertTrue(outContent.size() > 0);
    }
}