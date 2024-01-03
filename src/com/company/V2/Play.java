package com.company.V2;


import com.company.V2.domain.Item;
import com.company.V2.domain.Menu;
import com.company.V2.domain.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Play {
    /**
     * 한번에 주문하기 안됨.
     * 한개씩 삭제 안됨.
     */
    void play() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Menu> menus = new ArrayList<>();
        List<Item> burger = new ArrayList<>();
        Orders orders = new Orders();

        //초기 메뉴값 설정
        InitializeItemAndMenu initializeItemAndMenu = new InitializeItemAndMenu();
        menus = initializeItemAndMenu.initMenu();
        burger = initializeItemAndMenu.initBurger();

        MainBoard mainBoard = new MainBoard();
        BurgerBoard burgerBoard = new BurgerBoard();
        BuyBoard buyBoard = new BuyBoard();
        OrderBoard orderBoard = new OrderBoard();
        OrderCompletedBoard orderCompletedBoard = new OrderCompletedBoard();
        CancelBoard cancelBoard = new CancelBoard();

        int menuCount = menus.size();
        int burgerCount = burger.size();

        int waitingNumber = 1;
        while(true) {
            //mainBoard
            mainBoard.printMainBoard(menus);

            //itemBoard 선택
            int inputMenu = scanner.nextInt();

            //burgerBoard
            if (inputMenu == 1) {
                burgerBoard.printBurgerBoard(burger);

                int inputBurger = scanner.nextInt();
                //예외
                if(burgerCount < (inputBurger-1) || 0 > (inputBurger-1) ){
                    System.out.println("잘못된 숫자 입력했습니다.");
                    continue;
                }
                Item selectedItem = burger.get(inputBurger -1);
                //1 : 확인, 2 : 취소, 그외 잘못된 입력
                int isBuyingItem = buyBoard.printBuyBoard(selectedItem);
                if(isBuyingItem == 1){
                    orders.addOrder(selectedItem);
                }
            }

            // 메뉴 다른 거 만들으면 됨.
            if(inputMenu == 2){
                System.out.println("아직 메뉴가 없음");
            }

            //orderBoard
            if (inputMenu == menuCount + 1) {
                orderBoard.printOrders(orders);
                System.out.println("1. 주문   2. 메뉴판");
                int check = scanner.nextInt();
                if (check == 1) {
                    waitingNumber = orderCompletedBoard.printOrderCompleted(waitingNumber);
                }
            }

            //cancelBoard
            if (inputMenu == menuCount+2) {
                cancelBoard.printCancelBoard(orders);
            }
        }
    }
}
