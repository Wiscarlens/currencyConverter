package com.example.currencyconverter;

public class Currency {
    private String currencyName;
    private String currencySymbol;


    public Currency(String currencyName, String currencySymbol) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }


}
