package javatest.statistic;

import javatest.exception.EndOfStreamException;
import javatest.printer.StatisticsPrinter;
import javatest.reader.CharacterReader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractCharacterReaderStatistics {

    protected final Map<String, Long> frequencies = new ConcurrentHashMap<>();
    protected StatisticsPrinter statisticsPrinter;

    public AbstractCharacterReaderStatistics(StatisticsPrinter statisticsPrinter) {
        this.statisticsPrinter = statisticsPrinter;
    }

    public abstract void printStatistics();

    protected void generateStatistics(CharacterReader characterReader) {
        StringBuilder currentWord = new StringBuilder();

        try {
            while (true) {
                char nextChar = characterReader.getNextChar();
                if (Character.isLetter(nextChar)) {
                    currentWord.append(nextChar);
                } else {
                    appendToFrequenciesMap(currentWord);
                    currentWord.setLength(0);
                }
            }
        } catch (EndOfStreamException ex) {
            appendToFrequenciesMap(currentWord);
        }
    }

    protected void print() {
        statisticsPrinter.print(frequencies);
    }

    private void appendToFrequenciesMap(StringBuilder currentWord) {
        if (currentWord.length() != 0) {
            currentWord.setCharAt(0, Character.toUpperCase(currentWord.charAt(0)));
            frequencies.merge(currentWord.toString(), 1L, Long::sum);
        }
    }
}
