package com.company.V1.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private  List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addOrder(Item item) {
        items.add(item);
    }
    public void printOrders(){
        for (Item item : items) {
            System.out.println(item.getName() + "\t| " + item.getPrice() + " | " + item.getComment());
        }
    }
    public double totalPrice(){
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }
    public void cancelOrders(){
        items.clear();
    }
}
