package com.company.v3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TotalOrders {
    private List<Item> items = new ArrayList<>();
    private double totalPrice = 0;

    public double calculateTotalPrice(){
        List<Item> temp = items.stream().distinct().collect(Collectors.toList());
        for (Item item : temp) {
            totalPrice += item.getPrice()*(double)item.getQuantity();
        }
        return Math.round(totalPrice*100)/100.0;
    }

    public void printTotalOrders(){
        //List<Item> temp = items.stream().distinct().collect(Collectors.toList());
        for (Item item : items) {
            System.out.println(" - " + item.getName()
                    + "\t\t| W " + item.getPrice());
        }
    }
    public void addTotalOrders(Item item){
        items.add(item);
    }

    public TotalOrders() {
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
