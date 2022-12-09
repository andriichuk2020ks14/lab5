package com.example.demo.DemoApplication.dto;

public class DataDTO {

    public String date;
    public String baseCurrency;
    public String currency;
    public double saleRateNB;

    public DataDTO() {
    }

    public DataDTO(String date, String baseCurrency, String currency, double saleRateNB) {
        this.date = date;
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.saleRateNB = saleRateNB;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(double saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "date='" + date + '\'' +
                ", baseCurrency='" + baseCurrency + '\'' +
                ", currency='" + currency + '\'' +
                ", saleRateNB=" + saleRateNB +
                '}';
    }
}
