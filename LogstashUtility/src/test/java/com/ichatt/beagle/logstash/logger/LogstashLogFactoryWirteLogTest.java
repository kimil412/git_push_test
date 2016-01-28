package com.ichatt.beagle.logstash.logger;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import com.ichatt.beagle.logstash.logger.LogstashLoggerFactory;

//import ch.qos.logback.core.joran.spi.JoranException;
//import ch.qos.logback.core.util.StatusPrinter;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LogstashLogFactoryWirteLogTest {

	@Test
	public void logstashWriteTest() {
		justCallTestMethod(0, 500);
		try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
		//justCallTestMethod(230, 230);
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String libnameStr = LogstashLoggerFactory.getInstance().getLoggerImplementationLibraryName();
		System.out.println(libnameStr + "]]]]]]]]]]]]]]]]]]]]]]]");
		//assertEquals(libnameStr, "org.slf4j.impl.Log4jLoggerFactory");
		//assertEquals(libnameStr, "ch.qos.logback.classic.util.ContextSelectorStaticBinder");
		//assertEquals(libnameStr, "org.apache.logging.slf4j.Log4jLoggerFactory");
		/*boolean isLogbackImplBinded = LogstashLoggerFactory.getInstance().isLogbackImplementationBinded();
		assertEquals(true, isLogbackImplBinded);
		boolean isLog4jImplBinded = LogstashLoggerFactory.getInstance().isLog4jImplementationBinded();
		assertEquals(false, isLog4jImplBinded);*/
		
	}
	
	private void justCallTestMethod(int start, int end) {
		//LogstashLoggerFactory.getInstance().getLogger().debug("HIHIHI");
				//LogstashLoggerFactory.getInstance().writeLog();
				for(int i = start; i < start+end; i++)
					LogstashLoggerFactory.getInstance().getLogger().info("hihihihi43434]" + i);
					
				/*StatusPrinter.print(LogstashLoggerFactory.getInstance().getLoggerContext());
					
		        LogstashLoggerFactory.getInstance().getLoggerContext().stop();
		        //LogstashLoggerFactory.getInstance().getLoggerContext().reset();
		        LogstashLoggerFactory.getInstance().getLoggerContext().start();
		        try {
		        	System.out.println(LogstashLoggerFactory.getInstance().getLoggerContext().getStatusManager().getCount());
					LogstashLoggerFactory.getInstance().getContextInitializer().autoConfig();
				} catch (JoranException e) {
					e.printStackTrace();
				}*/
				
				
//		        for(int i = 230; i < 460; i++)
//					LogstashLoggerFactory.getInstance().getLogger().warn("hihihihi43434]" + i);
				
				//comment codes below cause of the tcp connection delay test.
				/*try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
	}
	
	
	public static void main(String[] args) {
//		new LogstashLogFactoryWirteLogTest().logstashWriteTest();
		System.err.println("ERERERERERERER");
//		
		new LogstashLogFactoryWirteLogTest().new BasicThreadPoolExecutorExample().mains(null);
	    
		System.out.println("Done sir");
		
		try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    
	}
	
	class Task implements Runnable
	{
	    private String name;
	 
	    public Task(String name)
	    {
	        this.name = name;
	    }
	     
	    public String getName() {
	        return name;
	    }
	 
	    @Override
	    public void run()
	    {
	        try
	        {
	            Long duration = (long) (Math.random() * 10);
	            System.out.println("Doing a task during : " + name);
	            //TimeUnit.SECONDS.sleep(duration);
	            new LogstashLogFactoryWirteLogTest().logstashWriteTest();
	        }
	        catch (/*InterruptedException e | */Exception e1)
	        {
	            e1.printStackTrace();
	        }
	    }
	}
	
	public class BasicThreadPoolExecutorExample
	{
	    public void mains(String[] args)
	    {
	        //Use the executor created by the newCachedThreadPool() method
	        //only when you have a reasonable number of threads
	        //or when they have a short duration.
	        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	        for (int i = 0; i < 100; i++)
	        {
	            Task task = new Task("Task " + i);
	            System.out.println("A new task has been added : " + task.getName());
	            executor.execute(task);
	        }
	        //executor.shutdown();
	        System.out.println("A new task has been added : " + "uhhhe");
	    }
	}
}
