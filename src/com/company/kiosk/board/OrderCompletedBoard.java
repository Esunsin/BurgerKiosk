package com.company.kiosk.board;

public class OrderCompletedBoard {
    public int printOrderCompleted(int waitingNumber) throws InterruptedException {
        int time = 3;
        
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + waitingNumber + " ] 번 입니다.");
        System.out.println("(" + time + "초후 메뉴판으로 돌아갑니다.)");
        Thread.sleep(time*1000);
        return (waitingNumber+1);
    }
}
