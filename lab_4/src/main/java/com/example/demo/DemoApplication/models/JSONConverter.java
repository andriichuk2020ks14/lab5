package com.example.demo.DemoApplication.models;

import java.util.ArrayList;

public class JSONConverter {

    public String date;
    public String bank;
    public int baseCurrency;
    public String baseCurrencyLit;
    public ArrayList<Data> exchangeRate;

    public JSONConverter() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(int baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public ArrayList<Data> getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ArrayList<Data> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
