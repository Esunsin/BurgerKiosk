package com.company.V3.board;

import com.company.V3.domain.Item;
import com.company.V3.domain.Orders;

import java.util.Scanner;

public class OrderBoard {
    public int printOrders(Orders orders){
        Scanner scanner = new Scanner(System.in);
        double totalPrice = orders.totalPrice();
        if (orders.getItems().size() > 0) {
            System.out.println("아래와 같이 주문하시겠습니까?");
            System.out.println("[ Orders ]");
            orders.printOrders();
            System.out.println(" [ Total ] ");
            System.out.println("W " + totalPrice);
        } else {
            System.out.println("주문 내역이 없습니다.");
        }
        System.out.println("1. 주문   2. 메뉴판");
        int check = scanner.nextInt();
        if(check == 1) orders.clearOrders();
        return check;
    }

}
