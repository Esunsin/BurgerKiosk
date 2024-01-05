package com.company.V4.board;

import com.company.V4.domain.Item;

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

}
