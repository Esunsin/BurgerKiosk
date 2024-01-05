package com.company.V4.board;

import com.company.V4.domain.Orders;

import java.util.Scanner;

public class CancelBoard {
    public void printCancelBoard(Orders orders) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인   2. 취소");
        int check = scanner.nextInt();
        if (check == 1) {
            orders.clearOrders();
            System.out.println("진행하던 주문이 취소되었습니다.");
        }
    }
}
