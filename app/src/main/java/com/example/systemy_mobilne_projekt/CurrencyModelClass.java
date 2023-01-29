package com.example.systemy_mobilne_projekt;

public class CurrencyModelClass {


    //nazwa i skrót waluty
    private String currency_name, currency_short;

    //ile pln jest warta 1 jednostka waluty
    private double valueToPln;

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getCurrency_short() {
        return currency_short;
    }

    public void setCurrency_short(String currency_short) {
        this.currency_short = currency_short;
    }

    public double getValueToPln() {
        return valueToPln;
    }

    public void setValueToPln(double valueToPln) {
        this.valueToPln = valueToPln;
    }
}
