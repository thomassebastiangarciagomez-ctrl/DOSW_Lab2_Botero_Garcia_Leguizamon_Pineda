package edu.eci.dosw.reto4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

public class ExchangeRateServiceTest {

    @Test
    public void convertShouldReturnSameAmountForSameCurrency() {
        ExchangeRateService service = new ExchangeRateService();
        double result = service.convert(100, "USD", "USD");
        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void convertShouldCalculateCorrectlyBetweenTwoNonBaseCurrencies() {
        ExchangeRateService service = new ExchangeRateService();
        // 50 EUR -> USD -> JPY, calculado vía moneda base
        double result = service.convert(50, "EUR", "JPY");
        double expected = (50 / 0.9175) * 156.85;
        assertEquals(expected, result, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertShouldThrowExceptionForUnknownCurrency() {
        ExchangeRateService service = new ExchangeRateService();
        service.convert(100, "USD", "XYZ");
    }

    @Test
    public void reportShouldSumConvertedAmountsAcrossTransactions() {
        ExchangeRateService service = new ExchangeRateService();

        List<CurrencyTransaction> transactions = List.of(
            new CurrencyTransaction(100, "USD", List.of("EUR")),
            new CurrencyTransaction(200, "USD", List.of("EUR"))
        );

        ExchangeReport report = new ExchangeReport(transactions, service);
        Map<String, Double> totals = report.getTotalsByCurrency();

        double expected = (100 * 0.9175) + (200 * 0.9175);
        assertEquals(expected, totals.get("EUR"), 0.01);
    }

    @Test
    public void reportShouldHandleMultipleTargetCurrenciesPerTransaction() {
        ExchangeRateService service = new ExchangeRateService();

        List<CurrencyTransaction> transactions = List.of(
            new CurrencyTransaction(100, "USD", List.of("EUR", "JPY"))
        );

        ExchangeReport report = new ExchangeReport(transactions, service);
        Map<String, Double> totals = report.getTotalsByCurrency();

        assertEquals(2, totals.size());
        assertEquals(91.75, totals.get("EUR"), 0.01);
        assertEquals(15685.0, totals.get("JPY"), 0.01);
    }
}