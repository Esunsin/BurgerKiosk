package com.company.V2.domain;

public class Item extends Menu {

    private double price;

    public Item(String name, String comment, double price) {
        super(name, comment);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + "\t| W "
                + price + " | "
                + getComment();
    }
}
