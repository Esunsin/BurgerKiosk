package com.company.V2;

import com.company.V2.domain.Menu;

import java.util.List;

public class MainBoard {

    void printMainBoard(List<Menu> menus){
        System.out.println();
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU ]");
        int i = 1;
        for (Menu menu : menus) {
            System.out.println(i + ". " + menu.toString());
            i++;
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(i+". Order            | 장바구니를 확인 후 주문합니다.");
        System.out.println((i+1)+". Cancel           | 진행중인 주문을 취소합니다.");
        System.out.print("번호를 입력해주세요 : ");
    }
}
