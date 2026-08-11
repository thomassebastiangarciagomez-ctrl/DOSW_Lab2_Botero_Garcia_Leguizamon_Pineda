package edu.eci.dosw.reto4;

import java.util.*;

public class ExchangeRateService {
    private final Map<String, Double> ratesFromBase;
    private final List<CurrencyInfo> supportedCurrencies;

    public ExchangeRateService() {
        // USD is used as the reference (base) currency to simplify the calculation
        // of any conversion pair without duplicating rates
        ratesFromBase = new HashMap<>();
        ratesFromBase.put("USD", 1.0);
        ratesFromBase.put("EUR", 0.9175);
        ratesFromBase.put("JPY", 156.85);
        ratesFromBase.put("COP", 3923.20);

        supportedCurrencies = List.of(
            new CurrencyInfo("USD", "US Dollar"),
            new CurrencyInfo("EUR", "Euro"),
            new CurrencyInfo("JPY", "Japanese Yen"),
            new CurrencyInfo("COP", "Colombian Peso")
        );
    }

    public List<CurrencyInfo> getSupportedCurrencies() {
        return new ArrayList<>(supportedCurrencies);
    }

    public double convert(double amount, String from, String to) {
        double fromRate = getRate(from);
        double toRate = getRate(to);

        double amountInBase = amount / fromRate;
        return amountInBase * toRate;
    }

    private double getRate(String currency) {
        Double rate = ratesFromBase.get(currency);
        if (rate == null) {
            throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
        return rate;
    }
}