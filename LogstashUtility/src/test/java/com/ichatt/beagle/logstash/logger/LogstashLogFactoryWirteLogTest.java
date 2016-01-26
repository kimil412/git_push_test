package com.ichatt.beagle.logstash.logger;

import static org.junit.Assert.*;
import org.junit.Test;
import com.ichatt.beagle.logstash.logger.LogstashLoggerFactory;

//import ch.qos.logback.core.joran.spi.JoranException;
//import ch.qos.logback.core.util.StatusPrinter;

public class LogstashLogFactoryWirteLogTest {

	@Test
	public void logstashWriteTest() {
		justCallTestMethod(0, 230);
		justCallTestMethod(230, 230);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String libnameStr = LogstashLoggerFactory.getInstance().getLoggerImplementationLibraryName();
		System.out.println(libnameStr + "]]]]]]]]]]]]]]]]]]]]]]]");
		//assertEquals(libnameStr, "org.slf4j.impl.Log4jLoggerFactory");
		//assertEquals(libnameStr, "ch.qos.logback.classic.util.ContextSelectorStaticBinder");
		//assertEquals(libnameStr, "org.apache.logging.slf4j.Log4jLoggerFactory");
		boolean isLogbackImplBinded = LogstashLoggerFactory.getInstance().isLogbackImplementationBinded();
		assertEquals(true, isLogbackImplBinded);
		boolean isLog4jImplBinded = LogstashLoggerFactory.getInstance().isLog4jImplementationBinded();
		assertEquals(false, isLog4jImplBinded);
		
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
		new LogstashLogFactoryWirteLogTest().logstashWriteTest();
		System.err.println("ERERERERERERER");
	}
}
