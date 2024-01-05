package com.company.V4.data;


import com.company.V4.domain.Category;
import com.company.V4.domain.Item;
import com.company.V4.domain.Menu;

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
        menuList.add(new Menu("Forzen Custard", "매장에서 신선하게 만드는 아이스크림"));
        menuList.add(new Menu("Drinks", "매장에서 직접 만드는 음료"));
        menuList.add(new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거"));
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

}
