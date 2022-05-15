package javatest.statistic;

import javatest.printer.StatisticsPrinter;
import javatest.reader.CharacterReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SlowCharacterReaderStatistics extends AbstractCharacterReaderStatistics {

    private final List<CharacterReader> characterReaders;

    public SlowCharacterReaderStatistics(List<CharacterReader> characterReaders, StatisticsPrinter statisticsPrinter) {
        super(statisticsPrinter);
        this.characterReaders = characterReaders;
    }

    @Override
    public void printStatistics() {
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(characterReaders.size(), 10));
        try {
            characterReaders.forEach(cr -> executor.submit(() -> generateStatistics(cr)));
            executor.shutdown();

            while (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                print();
            }
            print();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
