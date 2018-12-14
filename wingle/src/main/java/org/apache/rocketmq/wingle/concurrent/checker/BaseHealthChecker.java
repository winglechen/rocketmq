package org.apache.rocketmq.wingle.concurrent.checker;

import java.util.concurrent.CountDownLatch;

/**
 * org.apache.rocketmq.wingle.concurrent.checker
 *
 * @author Wingle
 * @create 2018/12/14 4:24 PM
 **/
public abstract class  BaseHealthChecker implements Runnable{
    private CountDownLatch latch;
    private String serviceName;
    private boolean serviceUp;

    public BaseHealthChecker(String serviceName, CountDownLatch latch) {
        super();
        this.serviceName = serviceName;
        this.latch = latch;
        this.serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Throwable t) {
            t.printStackTrace();
            serviceUp = false;
        } finally {
            if (null != latch) {
                latch.countDown();
            }
        }
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    public abstract void verifyService();
}
