package com.company.kiosk.board;

import com.company.kiosk.domain.TotalOrders;

import java.util.Scanner;

public class TotalOrdersBoard {
    public void printTotalOrdersBoard(TotalOrders totalOrders){

        System.out.println("[ 총 판매상품 목록 현황 ]\n"+
                "현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        totalOrders.printTotalOrders();
        System.out.println();
        System.out.println("[ 총 판매금액 현황 ]\n" +
                "현재까지 총 판매된 금액은 [ W " +
                totalOrders.getTotalPrice() +
                " ] 입니다.");
        System.out.println();

    }
    public void backToMainBoard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. 돌아가기");
        int check = scanner.nextInt();
        if(check != 1){
            System.out.println("입력이 바르지 않습니다. 처음 화면으로 돌아가겠습니다.");
        }
    }
}
