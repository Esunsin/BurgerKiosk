package com.company.kiosk.data;


import com.company.kiosk.domain.Category;
import com.company.kiosk.domain.Item;
import com.company.kiosk.domain.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 초기값
 */
public class InitializeItemAndMenu {

    public List<Menu> initMenu() {
        List<Menu> menuList = new ArrayList<>();
        Menu menu1 = new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거");
        menuList.add(menu1);
        menuList.add(new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림"));
        menuList.add(new Menu("Drinks", "매장에서 직접 만드는 음료"));
        menuList.add(new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));
        return menuList;
    }
    public List<Item> initBurger(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6.9, Category.BURGERS));
        itemList.add(new Item("SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",8.9, Category.BURGERS));
        itemList.add(new Item("Shroom Burger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9.4, Category.BURGERS));
        itemList.add(new Item("Cheeseburger","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6.9, Category.BURGERS));
        itemList.add(new Item("Hamburger","비프패티를 기반으로 야채가 들어간 기본버거",5.4, Category.BURGERS));
        return itemList;
    }
    public List<Item> initFrozenCustard(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Strawberry IceCream","딸기맛 아이스크림",2.9, Category.FORZEN_CUSTARD));
        itemList.add(new Item("Vanilla IceCream","바닐라맛 아이스크림",3.9, Category.FORZEN_CUSTARD));
        itemList.add(new Item("Mint IceCream","민트맛 아이스크림",3.5, Category.FORZEN_CUSTARD));
        return itemList;
    }
    public List<Item> initDrink(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Coke","콜라",1.9, Category.DRINKS));
        itemList.add(new Item("Sprite","사이다",1.9, Category.DRINKS));
        itemList.add(new Item("Water","물",1.0, Category.DRINKS));
        return itemList;
    }
    public List<Item> initBeer(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Lager","투명한 황금빛과 가볍고 밋밋한 향, 강한 탄산감이 특징인 맥주",5.9, Category.BEER));
        itemList.add(new Item("Ale","상대적으로 높은 온도에서 발효시켜, 달콤하고 풀 바디감이 느껴지며 과일향이 있는 맥주",7.9, Category.BEER));
        return itemList;
    }
}
