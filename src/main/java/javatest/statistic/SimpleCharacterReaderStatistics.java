package javatest.statistic;

import javatest.printer.StatisticsPrinter;
import javatest.reader.CharacterReader;

public class SimpleCharacterReaderStatistics extends AbstractCharacterReaderStatistics {

    private final CharacterReader characterReader;

    public SimpleCharacterReaderStatistics(CharacterReader characterReader, StatisticsPrinter statisticsPrinter) {
        super(statisticsPrinter);
        this.characterReader = characterReader;
    }

    @Override
    public void printStatistics() {
        generateStatistics(characterReader);
        print();
    }
}
