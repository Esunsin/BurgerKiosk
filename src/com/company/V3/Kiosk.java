package com.company.V3;


import com.company.V3.board.*;
import com.company.V3.data.InitializeItemAndMenu;
import com.company.V3.domain.Item;
import com.company.V3.domain.Menu;
import com.company.V3.domain.Orders;
import com.company.V3.domain.TotalOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Kiosk {
    /**
     * 한번에 주문하기 안됨.
     * 한개씩 삭제 안됨.
     */
    void on() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Orders orders = new Orders();

        //초기 메뉴값 설정
        InitializeItemAndMenu initializeItemAndMenu = new InitializeItemAndMenu();
        List<Menu> menus = initializeItemAndMenu.initMenu();
        List<Item> burger = initializeItemAndMenu.initBurger();

        TotalOrders totalOrders =new TotalOrders();

        //할당
        MainBoard mainBoard = new MainBoard();
        BurgerBoard burgerBoard = new BurgerBoard();
        BuyBoard buyBoard = new BuyBoard();
        OrderBoard orderBoard = new OrderBoard();
        OrderCompletedBoard orderCompletedBoard = new OrderCompletedBoard();
        CancelBoard cancelBoard = new CancelBoard();
        TotalOrdersBoard totalOrdersBoard = new TotalOrdersBoard();

        int menuCount = menus.size();
        int burgerCount = burger.size();

        int waitingNumber = 1;
        while(true) {
            //mainBoard
            mainBoard.printMainBoard(menus);

            //itemBoard 선택
            int inputMenu = scanner.nextInt();
            //TotalOrdersBoard
            if(inputMenu == 0){
                totalOrdersBoard.printTotalOrdersBoard(totalOrders);
                System.out.println("1. 돌아가기");
                int check = scanner.nextInt();
                if(check == 1){
                    continue;
                }
                else {
                    System.out.println("입력이 바르지 않습니다. 처음 화면으로 돌아가겠습니다.");
                }
            }
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
                totalOrders.addTotalOrders(selectedItem);
                totalOrders.calculateTotalPrice();
            }

            // 메뉴 다른 거 만들으면 됨.
            if(inputMenu == 2){
                System.out.println("아직 메뉴가 없음");
            }

            //orderBoard
            if (inputMenu == menuCount + 1) {
                int check = orderBoard.printOrders(orders);
                if (check == 1) {
                    waitingNumber = orderCompletedBoard.printOrderCompleted(waitingNumber);
                }
            }

            //cancelBoard
            if (inputMenu == menuCount+2) {
                cancelBoard.printCancelBoard(orders);
            }

            //종료
            if(inputMenu == 9){
                break;
            }
        }
    }
}
