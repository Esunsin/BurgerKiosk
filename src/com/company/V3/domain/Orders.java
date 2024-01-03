package com.company.V3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private  List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addOrder(Item item) {
        item.orderItem();
        items.add(item);

    }
    public void printOrders(){
        List<Item> temp = items.stream().distinct().collect(Collectors.toList());
        for (Item item : temp) {
            System.out.println(item.toString());
        }
    }
    public double totalPrice(){
        double sum = 0;
        List<Item> temp = items.stream().distinct().collect(Collectors.toList());
        for (Item item : temp) {
            sum += item.getPrice()*(double)item.getQuantity();
        }
        return sum;
    }
    public void clearOrders(){
        for (Item item : items) {
            item.clearQuantityItem();
        }
        items.clear();
    }


}
