package javatest;

import javatest.printer.ConsoleStatisticsPrinter;
import javatest.reader.SimpleCharacterReader;
import javatest.statistic.AbstractCharacterReaderStatistics;
import javatest.statistic.SimpleCharacterReaderStatistics;

public class SimpleCharacterReaderDemo {
    public static void main(String[] args) {
        AbstractCharacterReaderStatistics characterReaderStatistics =
                new SimpleCharacterReaderStatistics(new SimpleCharacterReader(), new ConsoleStatisticsPrinter());
        characterReaderStatistics.printStatistics();
    }
}
