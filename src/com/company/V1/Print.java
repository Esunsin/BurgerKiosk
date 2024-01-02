package com.company.V1;

import com.company.V1.entity.Item;
import com.company.V1.entity.Menu;
import com.company.V1.entity.Orders;

import java.util.List;

public class Print {

    void mainBoard(List<Menu> menuList){
        System.out.println("[ SHAKESHACK MENU ]");
        int i = 1;
        for (Menu menu : menuList) {
            System.out.println(i + ". " + menu.getName() + "\t\t\t| " + menu.getComment());
            i++;
        }
//        System.out.println("1. Burgers          | 앵거스 비프 통살을 다져만든 버거");
//        System.out.println("2. Forzen Custard   | 매장에서 신선하게 만드는 아이스크림");
//        System.out.println("3. Drinks           | 매장에서 직접 만드는 음료");
//        System.out.println("4. Beer             | 뉴욕 브루클린 브루어리에서 양조한 맥주");
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(i+". Order            | 장바구니를 확인 후 주문합니다.");
        System.out.println((i+1)+". Cancel           | 진행중인 주문을 취소합니다.");
    }

    void burgerBoard(List<Item> itemList){
        System.out.println("[ Burgers MENU ]");
        int i=1;
        for (Item item : itemList) {
            System.out.println(i + ". " + item.getName() + "\t| W " + item.getPrice() + " | " + item.getComment());
            i++;
        }
//        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
//        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
//        System.out.println("3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
//        System.out.println("4. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
//        System.out.println("5. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.print("한개의 번호를 입력해 주세요 : ");
    }
    void buyBoard(Orders orders){

    }

}
