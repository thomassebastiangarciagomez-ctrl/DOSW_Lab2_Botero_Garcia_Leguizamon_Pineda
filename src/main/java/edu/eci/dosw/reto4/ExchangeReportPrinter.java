package edu.eci.dosw.reto4;

import java.util.*;
import java.util.stream.*;

public class ExchangeReportPrinter {

    private ExchangeReportPrinter() {
    }

    public static void print(List<CurrencyTransaction> transactions,
                              ExchangeRateService exchangeRateService,
                              ExchangeReport report) {

        IntStream.range(0, transactions.size())
            .forEach(i -> {
                CurrencyTransaction t = transactions.get(i);
                System.out.printf("Transacción %d: %.0f %s%n",
                        i + 1, t.getAmount(), t.getCurrencyName());

                t.getTargetCurrencies().forEach(target -> {
                    double converted = exchangeRateService.convert(
                            t.getAmount(), t.getCurrencyName(), target);
                    System.out.printf("Convertido a %s: %.2f %s%n", target, converted, target);
                });

                System.out.println();
            });

        System.out.println("Totales por moneda:");
        Map<String, Double> totals = report.getTotalsByCurrency();
        String summary = totals.entrySet().stream()
            .map(e -> String.format("%s: %.2f", e.getKey(), e.getValue()))
            .reduce((a, b) -> a + " · " + b)
            .orElse("");
        System.out.println(summary);
    }
}