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
        List<Item> frozen = initializeItemAndMenu.initFrozenCustard();
        List<Item> drink = initializeItemAndMenu.initDrink();
        List<Item> beer = initializeItemAndMenu.initBeer();

        TotalOrders totalOrders =new TotalOrders();

        //할당
        MainBoard mainBoard = new MainBoard();
        ItemBoard itemBoard = new ItemBoard();
        BuyBoard buyBoard = new BuyBoard();
        OrderBoard orderBoard = new OrderBoard();
        OrderCompletedBoard orderCompletedBoard = new OrderCompletedBoard();
        CancelBoard cancelBoard = new CancelBoard();
        TotalOrdersBoard totalOrdersBoard = new TotalOrdersBoard();

        int menuCount = menus.size();

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
            //burger
            if (inputMenu == 1) {
                itemBoard.printItemBoard(burger);

                int inputItemNumber = buyBoard.printSelectBuyItem(burger.size());
                Item selectedItem = burger.get(inputItemNumber);

                if(buyBoard.isBuyItem(selectedItem)){
                    orders.addOrder(selectedItem);
                }
            }
            //frozen custard
            if (inputMenu == 2) {
                itemBoard.printItemBoard(frozen);

                int inputItemNumber = buyBoard.printSelectBuyItem(frozen.size());
                Item selectedItem = frozen.get(inputItemNumber);

                if(buyBoard.isBuyItem(selectedItem)){
                    orders.addOrder(selectedItem);
                }
            }
            //drink
            if (inputMenu == 3) {
                itemBoard.printItemBoard(drink);

                int inputItemNumber = buyBoard.printSelectBuyItem(drink.size());
                Item selectedItem = drink.get(inputItemNumber);

                if(buyBoard.isBuyItem(selectedItem)){
                    orders.addOrder(selectedItem);
                }
            }
            //beer
            if (inputMenu == 4) {
                itemBoard.printItemBoard(beer);

                int inputItemNumber = buyBoard.printSelectBuyItem(beer.size());
                Item selectedItem = beer.get(inputItemNumber);

                if(buyBoard.isBuyItem(selectedItem)){
                    orders.addOrder(selectedItem);
                }
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
            if(inputMenu > menuCount+2){
                System.out.println("메뉴에 없는 숫자입니다. 종료하겠습니다.");
                break;
            }
        }
    }
}
