package com.company.V4;


import com.company.V4.board.*;
import com.company.V4.data.InitializeItemAndMenu;
import com.company.V4.domain.Item;
import com.company.V4.domain.Menu;
import com.company.V4.domain.Orders;
import com.company.V4.domain.TotalOrders;

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
                totalOrdersBoard.backToMainBoard();
            }
            //burgerBoard
            if (inputMenu == 1) {
                burgerBoard.printBurgerBoard(burger);

                int inputItemNumber = buyBoard.printSelectBuyItem(burgerCount);
                Item selectedItem = burger.get(inputItemNumber);

                if(buyBoard.isBuyItem(selectedItem)){
                    orders.addOrder(selectedItem);
                }
            }

            // 메뉴 다른 거 만들으면 됨.
            if(inputMenu >= 2 && inputMenu <= menuCount){
                System.out.println("아직 메뉴가 없음");
            }

            //orderBoard
            if (inputMenu == menuCount + 1) {
                if (orderBoard.isOrders(orders)) {
                    totalOrders.addTotalOrders(orders);
                    totalOrders.calculateOrdersPrice(orders);
                    orders.clearOrders();
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
