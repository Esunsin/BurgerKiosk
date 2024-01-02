package com.company.V2;

import com.company.V2.entity.Orders;

import java.util.Scanner;

public class CancelBoard {
    void printCancelBoard(Orders orders) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인   2. 취소");
        int check = scanner.nextInt();
        if (check == 1) {
            orders.cancelOrders();
            System.out.println("진행하던 주문이 취소되었습니다.");
        }
    }
}
