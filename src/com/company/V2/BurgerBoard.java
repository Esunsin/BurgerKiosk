package com.company.V2;

import com.company.V2.entity.Item;

import java.util.List;
import java.util.Scanner;

public class BurgerBoard {

    void printBurgerBoard(List<Item> itemList){
        System.out.println("[ Burgers MENU ]");
        int i=1;
        for (Item item : itemList) {
            System.out.println(i + ". " + item.toString());
            i++;
        }
        System.out.print("한개의 번호를 입력해 주세요 : ");
    }

}
