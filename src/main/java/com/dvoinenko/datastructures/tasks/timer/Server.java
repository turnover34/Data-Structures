package com.dvoinenko.datastructures.tasks.timer;

public class Server {
    private int port;

    public static void main(String[] args) throws InterruptedException {
        Timer timer1 = new Timer("first", 10);
        Timer timer2 = new Timer("second", 20);
        Timer timer3 = new Timer("third", 30);
        timer1.start();
        timer2.start();
        timer3.start();
    }
}
