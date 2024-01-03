package com.company.V3.board;

import com.company.V3.domain.Item;

import java.util.List;

public class BurgerBoard {

    public void printBurgerBoard(List<Item> itemList){
        System.out.println("[ Burgers MENU ]");
        int i=1;
        for (Item item : itemList) {
            System.out.println(i + ". " + item.getName() + "\t| W "
                    + item.getPrice() + " | "
                    + item.getComment());
            i++;
        }
        System.out.print("한개의 번호를 입력해 주세요 : ");
    }

}
