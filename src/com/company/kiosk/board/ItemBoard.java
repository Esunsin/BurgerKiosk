package com.company.kiosk.board;

import com.company.kiosk.domain.Item;
import com.company.kiosk.domain.Orders;

import java.util.List;

public class ItemBoard {

    public void printItemBoard(List<Item> itemList){
        System.out.println("[ "+ itemList.get(0).getCategory() +" MENU ]");
        int i=1;
        for (Item item : itemList) {
            System.out.println(i + ". " + item.getName() + "\t| W "
                    + item.getPrice() + " | "
                    + item.getComment());
            i++;
        }
    }
    public void selectedItemBoard(Orders orders , List<Item> items , BuyBoard buyBoard){
        printItemBoard(items);

        int inputItemNumber = buyBoard.printSelectBuyItem(items.size());
        Item selectedItem = items.get(inputItemNumber);

        if(buyBoard.isBuyItem(selectedItem)){
            orders.addOrder(selectedItem);
        }
    }
}
