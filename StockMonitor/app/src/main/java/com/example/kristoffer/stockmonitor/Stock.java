package com.example.kristoffer.stockmonitor;

public class Stock {
    private String name;
    private int price;
    private int amount;
    private String sector;

    public Stock(String name, int price, int amount, String sector){
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.sector = sector;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public int getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
