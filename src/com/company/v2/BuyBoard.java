package com.company.v2;

import com.company.v2.domain.Item;

import java.util.Scanner;

public class BuyBoard {

    int printBuyBoard(Item item){
        System.out.println(item.toString());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인   2. 취소");
        return checkBuyItem(item);
    }
    int checkBuyItem(Item item){
        Scanner scanner = new Scanner(System.in);
        int check = scanner.nextInt();
        if (check == 1) {
            System.out.println(item.getName() + "가 장바구니에 추가되었습니다.");
        } else if (check == 2) {
            System.out.println("진행하던 주문이 취소되었습니다.");
        } else {
            System.out.println("잘못 입력 했습니다. 다시 주문해주세요.");
        }
        return check;
    }
}
