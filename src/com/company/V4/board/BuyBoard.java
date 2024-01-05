package com.company.V4.board;

import com.company.V4.domain.Item;

import java.util.List;
import java.util.Scanner;

public class BuyBoard {


    public int printSelectBuyItem(int itemCount){
        Scanner scanner = new Scanner(System.in);
        System.out.print("한개의 번호를 입력해 주세요 : ");
        int inputBurger = scanner.nextInt();
        //예외
        if(itemCount < (inputBurger-1) || 0 > (inputBurger-1) ){
            System.out.println("잘못된 숫자 입력했습니다.");
        }
        return inputBurger-1;

    }

    //1이면 삼 2이면 취소 그외 예외 발생
    public boolean isBuyItem(Item item){
        Scanner scanner = new Scanner(System.in);
        System.out.println(item.printItem());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인   2. 취소");
        int check = scanner.nextInt();
        if (check == 1) {
            System.out.println(item.getName() + "가 장바구니에 추가되었습니다.");
            return true;
        } else if (check == 2) {
            System.out.println("진행하던 주문이 취소되었습니다.");
        } else {
            System.out.println("잘못 입력 했습니다. 다시 주문해주세요.");
        }
        return false;
    }
}
