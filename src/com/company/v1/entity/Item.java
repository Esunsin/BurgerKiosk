package com.company.v1.entity;

public class Item extends Menu{

    private double price;

    public Item(String name, String comment, double price) {
        super(name, comment);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


}
