package edu.eci.dosw.reto4;

import java.util.*;
import java.util.stream.*;

public class ExchangeReport {

    private final List<CurrencyTransaction> transactions;
    private final ExchangeRateService exchangeRateService;

    public ExchangeReport(List<CurrencyTransaction> transactions, ExchangeRateService exchangeRateService) {
        this.transactions = new ArrayList<>(transactions);
        this.exchangeRateService = exchangeRateService;
    }

    /**
     * Sums the converted amounts by target currency, across all transactions.
     * Uses flatMap because each transaction may convert to several currencies: flatMap
     * "flattens" that list of lists into a single stream of (currency, converted amount)
     * pairs before grouping and summing.
     */
    public Map<String, Double> getTotalsByCurrency() {
        return transactions.stream()
            .flatMap(t -> t.getTargetCurrencies().stream()
                .map(target -> new AbstractMap.SimpleEntry<>(
                        target,
                        exchangeRateService.convert(t.getAmount(), t.getCurrencyName(), target))))
            .collect(Collectors.groupingBy(
                    Map.Entry::getKey,
                    Collectors.summingDouble(Map.Entry::getValue)));
    }
}