package com.ichatt.beagle.logstash.logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class LogstashLogFactoryWirteLogTest {

    @Test
    public void logstashWriteTest() {
        justCallTestMethod(0, 500);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            /* wait time to keep the Logstash connection alive. */
            /*- TCP connection that will be out when this program exit.*/
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* printing the implementation package name */
        String libnameStr = LogstashLoggerFactory.getInstance().getLoggerImplementationLibraryName();
        System.out.println("Slf4j implementation library is " + libnameStr);

    }

    private void justCallTestMethod(int start, int end) {
        for (int i = start; i < start + end; i++)
            LogstashLoggerFactory.getInstance().getLogger().info("hihihihi43434]" + i);
    }

    public static void main(String[] args) {
        System.err.println("MAIN METHOD STARTED NOT NORMAL CASE!!!");

        new LogstashLogFactoryWirteLogTest().new BasicThreadPoolExecutorExample().mains(null);

        System.out.println("Done sir");

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                System.out.println("Doing a task during : " + name);
                new LogstashLogFactoryWirteLogTest().logstashWriteTest();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public class BasicThreadPoolExecutorExample {
        public void mains(String[] args) {
            // Use the executor created by the newCachedThreadPool() method
            // only when you have a reasonable number of threads
            // or when they have a short duration.
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
            for (int i = 0; i < 100; i++) {
                Task task = new Task("Task " + i);
                System.out.println("A new task has been added : " + task.getName());
                executor.execute(task);
            }
            executor.shutdown();
            System.out.println("A new task has been added : " + "uhhhe");
        }
    }
}
