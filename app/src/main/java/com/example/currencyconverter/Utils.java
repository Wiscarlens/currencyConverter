package com.example.currencyconverter;

import java.text.NumberFormat;

public class Utils {
    public static String formatDouble(double value) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMaximumFractionDigits(2);
        return formatter.format(value);
    }
}
