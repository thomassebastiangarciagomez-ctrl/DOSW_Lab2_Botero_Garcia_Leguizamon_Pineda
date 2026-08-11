package edu.eci.dosw.reto4;
import java.util.*;

public class CurrencyTransaction {

    private final double amount;
    private final String currencyName;
    private final List<String> targetCurrencies;

    public CurrencyTransaction(double amount, String currencyName, List<String> targetCurrencies) {
        this.amount = amount;
        this.currencyName = currencyName;
        this.targetCurrencies = new ArrayList<>(targetCurrencies);
    }

    public double getAmount(){
        return amount;
    }

    public String getCurrencyName(){
        return currencyName;
    }

    public List<String> getTargetCurrencies(){
        return new ArrayList<>(targetCurrencies);
    }

}
