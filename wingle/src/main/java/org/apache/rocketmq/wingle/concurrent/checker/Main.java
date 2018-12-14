package org.apache.rocketmq.wingle.concurrent.checker;

/**
 * org.apache.rocketmq.wingle.concurrent.checker
 *
 * @author Wingle
 * @create 2018/12/14 4:55 PM
 **/
public class Main {
    public static void main(String[] args) {
        boolean state = false;

        try {
            state = HealthChecker.check();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Health checking completed!");
    }
}
