package com.company.V3.domain;

public class Item extends Menu {

    private double price;
    private int quantity;
    private Category category;

    public Item(String name, String comment, double price,Category category) {
        super(name, comment);
        this.price = price;
        this.category = category;
    }
    public int getQuantity(){
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + "\t| W "
                + price + " | "
                + quantity + "개 | "
                + getComment();
    }
    public String printItem() {
        return getName() + "\t| W "
                + price + " | "
                + getComment();
    }
    public void orderItem(){
        quantity++;
    }
    public void clearQuantityItem(){
        this.quantity = 0;
    }
}
