package com.company.V1;


import com.company.V1.entity.Item;
import com.company.V1.entity.Menu;
import com.company.V1.entity.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Play {
    /**
     * 한번에 주문하기 안됨.
     * 한개씩 삭제 안됨.
     */
    void play() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        InitializeItemAndMenu initializeItemAndMenu = new InitializeItemAndMenu();
        Orders orders = new Orders();
        List<Menu> menus = new ArrayList<>();
        List<Item> burger = new ArrayList<>();
        Print print = new Print();
        menus = initializeItemAndMenu.initMenu();
        burger = initializeItemAndMenu.initBurger();
        int menuCount = menus.size();
        int burgerCount = burger.size();
        int m = 0;
        while(true) {
            print.mainBoard(menus);
            System.out.print("번호를 입력해주세요 : ");
            int inputMenu = scanner.nextInt();
            if (inputMenu == 1) {
                print.burgerBoard(burger);
                int inputBurger = scanner.nextInt();
                System.out.println(burger.get(inputBurger-1).getName() + "\t| W " + burger.get(inputBurger-1).getPrice() + " | " + burger.get(inputBurger-1).getComment());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인   2. 취소");
                int check = scanner.nextInt();
                if (check == 1) {
                    orders.addOrder(burger.get(inputBurger-1));
                    System.out.println(burger.get(inputBurger-1).getName() + "가 장바구니에 추가되었습니다.");
                } else if (check == 2) {
                    System.out.println("진행하던 주문이 취소되었습니다.");
                } else {
                    System.out.println("잘못 입력 했습니다. 다시 주문해주세요.");
                }
            }
            // 메뉴 다른 거 만들기

            //order
            if (inputMenu == menuCount + 1) {
                double totalPrice = orders.totalPrice();
                if (orders.getItems().size() > 0) {
                    System.out.println("[ Orders ]");
                    for (Item item : orders.getItems()) {
                        System.out.println(item.getName() + "\t| W " + item.getPrice() + " | " + item.getComment());
                    }
                    System.out.println(" [ Total ] ");
                    System.out.println("W " + totalPrice);
                    m++;
                } else {
                    System.out.println("주문 내역이 없습니다.");
                }
                System.out.println("1. 주문  2. 메뉴판");
                int check = scanner.nextInt();
                if (check == 1) {
                    int time = 3;
                    System.out.println("주문이 완료되었습니다!");
                    System.out.println();
                    System.out.println("대기번호는 [ " + m + " ] 번 입니다.");
                    System.out.println("(" + time + "초후 메뉴판으로 돌아갑니다.)");
                    Thread.sleep(time*1000);
                } else if (check == 2) {
                    m--;
                    //메뉴판으로
                    continue;
                }
            }
            //cancel
            if (inputMenu == menuCount+2) {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1. 확인   2. 취소");
                int check = scanner.nextInt();
                if (check == 1) {
                    orders.cancelOrders();
                    System.out.println("진행하던 주문이 취소되었습니다.");
                } else if (check == 2) {
                    continue;
                }
            }
        }
    }
}
