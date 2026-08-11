package edu.eci.dosw.reto4;

public class CurrencyInfo {

    private final String code;
    private final String fullName;

    public CurrencyInfo(String code, String fullName){
        this.code = code;
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

}
