package com.company.V4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TotalOrders {
    private List<Item> items = new ArrayList<>();
    private double totalPrice = 0;

    public void printTotalOrders(){
        //List<Item> temp = items.stream().distinct().collect(Collectors.toList());
        for (Item item : items) {
            System.out.println(" - " + item.getName()
                    + "\t\t| W " + item.getPrice());
        }
    }
    public void addTotalOrders(Orders orders){
        for (Item item : orders.getItems()) {
            items.add(item);
        }
    }

    public void calculateOrdersPrice(Orders orders){
        for (Item item : orders.getItems()) {
            totalPrice += item.getPrice()*item.getQuantity();
        }
    }

    public TotalOrders() {
    }


    public double getTotalPrice() {
        return Math.round(totalPrice*100)/100.0;
    }
}
