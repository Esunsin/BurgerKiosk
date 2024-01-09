package com.company.kiosk;


import com.company.kiosk.board.*;
import com.company.kiosk.data.InitializeItemAndMenu;
import com.company.kiosk.domain.Item;
import com.company.kiosk.domain.Menu;
import com.company.kiosk.domain.Orders;
import com.company.kiosk.domain.TotalOrders;

import java.util.List;
import java.util.Scanner;


public class Kiosk {
    void on() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Orders orders = new Orders();

        //초기 메뉴값 설정
        InitializeItemAndMenu data = new InitializeItemAndMenu();
        int menuCount = data.menus().size();

        //할당
        MainBoard mainBoard = new MainBoard();
        ItemBoard itemBoard = new ItemBoard();
        BuyBoard buyBoard = new BuyBoard();
        OrderBoard orderBoard = new OrderBoard();
        CancelBoard cancelBoard = new CancelBoard();
        TotalOrdersBoard totalOrdersBoard = new TotalOrdersBoard();

        TotalOrders totalOrders =new TotalOrders();

        int waitingNumber = 1;

        while(true) {
            //mainBoard
            mainBoard.printMainBoard(data.menus());

            //itemBoard 선택
            int inputMenu = scanner.nextInt();

            //TotalOrdersBoard
            if(inputMenu == 0){
                totalOrdersBoard.printTotalOrdersBoard(totalOrders);
                totalOrdersBoard.backToMainBoard();
            }
            //burgers
            if (inputMenu == 1) {
                itemBoard.selectedItemBoard(orders,data.burgers(),buyBoard);
            }
            //frozenCustards custard
            if (inputMenu == 2) {
                itemBoard.selectedItemBoard(orders,data.frozenCustards(),buyBoard);
            }
            //drinks
            if (inputMenu == 3) {
                itemBoard.selectedItemBoard(orders,data.drinks(),buyBoard);
            }
            //beers
            if (inputMenu == 4) {
                itemBoard.selectedItemBoard(orders,data.beers(),buyBoard);
            }
            //orderBoard
            if (inputMenu == menuCount + 1) {
                if (orderBoard.isOrders(orders)) {
                    totalOrders.addTotalOrders(orders);
                    totalOrders.calculateOrdersPrice(orders);
                    orders.clearOrders();
                    waitingNumber = orderBoard.printOrderCompleted(waitingNumber);
                }
            }

            //cancelBoard
            if (inputMenu == menuCount+2) {
                cancelBoard.printCancelBoard(orders);
            }

            //예외
            if(inputMenu > menuCount+2){
                System.out.println("메뉴에 없는 숫자입니다. 메인으로 돌아갑니다.");
            }
        }
    }
}
