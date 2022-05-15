package javatest;

import javatest.reader.SlowCharacterReader;
import javatest.printer.ConsoleStatisticsPrinter;
import javatest.statistic.AbstractCharacterReaderStatistics;
import javatest.statistic.SlowCharacterReaderStatistics;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlowCharacterReaderDemo {
    public static void main(String[] args) {
        AbstractCharacterReaderStatistics slowCharacterReaderStatistics = new SlowCharacterReaderStatistics(
                IntStream.range(0, 10).mapToObj(i -> new SlowCharacterReader()).collect(Collectors.toList()),
                new ConsoleStatisticsPrinter());
        slowCharacterReaderStatistics.printStatistics();
    }
}
