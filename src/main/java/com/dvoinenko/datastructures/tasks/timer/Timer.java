package com.dvoinenko.datastructures.tasks.timer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Timer extends Thread implements Runnable {
    private String timerName;
    private int time;

    public Timer(String timerName, int time) {
        this.timerName = timerName;
        this.time = time;
    }

    @Override
    public void run() {
        int count = time;
        String name = timerName;
        while (count > 0) {
            System.out.println(timerName + " : " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
        }
        System.out.println("Timer " + timerName + " has finished counting");
    }
}
