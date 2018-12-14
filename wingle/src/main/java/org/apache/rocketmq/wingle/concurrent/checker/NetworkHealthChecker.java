package org.apache.rocketmq.wingle.concurrent.checker;

import java.util.concurrent.CountDownLatch;

/**
 * org.apache.rocketmq.wingle.concurrent.checker
 *
 * @author Wingle
 * @create 2018/12/14 4:34 PM
 **/
public class NetworkHealthChecker extends BaseHealthChecker {
    public NetworkHealthChecker(CountDownLatch latch) {
        super("Network Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getServiceName() + " is UP");
    }
}
