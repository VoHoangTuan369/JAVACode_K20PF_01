package com.company;

public class NumberAccount {
    private int numberAccount = 0;

    public synchronized void add(int num){
        if (numberAccount == 0){

        }
        numberAccount += num;
        System.out.println("Đã nộp vào " + num);
        notify();
    }

    public synchronized void sub(int num){
        if (numberAccount < 50000){
            System.out.println("Số dư phải lớn hơn 50000!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numberAccount -= num;
        System.out.println("Đã rút " + num);
    }
}
