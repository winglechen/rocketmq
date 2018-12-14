package org.apache.rocketmq.wingle.concurrent.barrier;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

/**
 * org.apache.rocketmq.wingle.concurrent.barrier
 *
 * @author Wingle
 * @create 2018/12/14 5:31 PM
 **/
public class Game implements Runnable {
    @Getter
    private String player;
    private CyclicBarrier barrier;

    public Game(String player, CyclicBarrier barrier) {
        this.player = player;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            findOtherPlayer();
            barrier.await();

            choiceRole();
            barrier.await();

            loading();
            barrier.await();

            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findOtherPlayer() throws InterruptedException {
        System.out.println(this.getPlayer() + " finding other player");
        Thread.sleep((long)(1000*Math.random()));
    }

    public void choiceRole() throws InterruptedException {
        System.out.println(this.getPlayer() + " choicing role");
        Thread.sleep((long)(3000*Math.random()));
    }

    public void loading() throws InterruptedException {
        System.out.println(this.getPlayer() + " loading ...");
        Thread.sleep((long)(5000*Math.random()));
    }

    public void start() {
        System.out.println(this.getPlayer() + " start...");
    }
}
