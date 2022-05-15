package javatest.printer;

import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleStatisticsPrinter implements StatisticsPrinter {

    public void print(Map<String, Long> statisticsMap) {
        statisticsMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(p -> p.getKey() + " - " + p.getValue())
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------------------------------");
    }
}
