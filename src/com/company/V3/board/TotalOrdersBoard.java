package com.company.V3.board;

import com.company.V3.domain.TotalOrders;

public class TotalOrdersBoard {
    public void printTotalOrdersBoard(TotalOrders totalOrders){

        System.out.println("[ 총 판매상품 목록 현황 ]\n"+
                "현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        totalOrders.printTotalOrders();
        System.out.println();
        System.out.println("[ 총 판매금액 현황 ]\n" +
                "현재까지 총 판매된 금액은 [ W " +
                totalOrders.calculateTotalPrice() +
                " ] 입니다.");
        System.out.println();

    }
}
