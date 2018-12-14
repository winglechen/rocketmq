package org.apache.rocketmq.wingle.concurrent.barrier;

import java.util.concurrent.CyclicBarrier;

/**
 * org.apache.rocketmq.wingle.concurrent.barrier
 *
 * @author Wingle
 * @create 2018/12/14 5:42 PM
 **/
public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
           try {
               System.out.println("阶段完成，等待1秒...");
               Thread.sleep(1000);
               System.out.println("进入下一阶段 ...");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });


        Thread player1 = new Thread(new Game("1", barrier));
        Thread player2 = new Thread(new Game("2", barrier));
        Thread player3 = new Thread(new Game("3", barrier));
        Thread player4 = new Thread(new Game("4", barrier));
        Thread player5 = new Thread(new Game("5", barrier));

        player1.start();
        player2.start();
        player3.start();
        player4.start();
        player5.start();

//        System.in.read();
    }
}
