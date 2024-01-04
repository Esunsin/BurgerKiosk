package com.company.v3;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        //test
        Kiosk kiosk = new Kiosk();
        kiosk.on();
    }
}

//Q. 실무적인 관점에서 봤을 때
//1. 메뉴별 객체를 만드는 것 -> 이점이 궁금
//2. item 객체 + 카테고리 필드으로 추가 -> 다른 카테고리 추가로 만들기 용이하고 + 메뉴별 객체 중복적인 내용을 해결예상
