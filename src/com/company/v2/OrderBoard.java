package com.company.v2;

import com.company.v2.domain.Item;
import com.company.v2.domain.Orders;

public class OrderBoard {
    void printOrders(Orders orders){
        double totalPrice = orders.totalPrice();
        if (orders.getItems().size() > 0) {
            System.out.println("[ Orders ]");
            for (Item item : orders.getItems()) {
                System.out.println(item.toString());
            }
            System.out.println(" [ Total ] ");
            System.out.println("W " + totalPrice);
        } else {
            System.out.println("주문 내역이 없습니다.");
        }
    }

}
