package org.apache.rocketmq.wingle.concurrent.checker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * org.apache.rocketmq.wingle.concurrent.checker
 *
 * @author Wingle
 * @create 2018/12/14 4:43 PM
 **/
public class HealthChecker {
    private static List<BaseHealthChecker> checkers;
    private static CountDownLatch latch;

    private final static HealthChecker INSTANCE = new HealthChecker();
    private HealthChecker() {}
    public static HealthChecker getInstance() {
        return INSTANCE;
    }

    public static boolean check() throws Exception {
        latch = new CountDownLatch(3);
        checkers = new ArrayList<>();

        checkers.add(new NetworkHealthChecker(latch));
        checkers.add(new DatabaseHealthChecker(latch));
        checkers.add(new CacheHealthChecker(latch));

        Executor executor = Executors.newFixedThreadPool(checkers.size());

        for(final BaseHealthChecker c : checkers) {
            executor.execute(c);
        }
        latch.await();

        for(final BaseHealthChecker c : checkers) {
            if(! c.isServiceUp()) {
                return false;
            }
        }
        return true;
    }


}
