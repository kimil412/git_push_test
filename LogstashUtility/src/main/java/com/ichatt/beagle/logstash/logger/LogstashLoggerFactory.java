package com.ichatt.beagle.logstash.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.classic.util.ContextInitializer;

//import org.apache.log4j.Logger;

public class LogstashLoggerFactory {

    private int connectPortNumber;
    private static LogstashLoggerFactory instance = null;

    protected LogstashLoggerFactory() {
        connectPortNumber = 2323;
    }
    
    public static LogstashLoggerFactory getInstance() {
        if( instance == null ) {
            instance = new LogstashLoggerFactory();
        }

        return instance;
    }

    public void setConnectPortNumber(int portNumber) {
    	this.connectPortNumber = portNumber;
    }
    
    public int getConnectPortNumber() {
    	return this.connectPortNumber;
    }
    public Logger getLogger() {
    	//return Logger.getLogger(LogstashLoggerFactory.class);
    	//System.out.println(LogstashLoggerFactory.class.getName());
    	return LoggerFactory.getLogger(LogstashLoggerFactory.class);
    	//return Logger.getRootLogger();
    }
    
   /* public LoggerContext getLoggerContext() {
    	return (LoggerContext) LoggerFactory.getILoggerFactory();
    }
    
    public ContextInitializer getContextInitializer() {
    	ContextInitializer co = new ContextInitializer((LoggerContext) LoggerFactory.getILoggerFactory());
    	return co;
    }*/
    public String getLoggerImplementationLibraryName(){
    	StaticLoggerBinder binder = StaticLoggerBinder.getSingleton();
    	return binder.getLoggerFactoryClassStr();
    }
    
    public boolean isLog4jImplementationBinded(){
    	return getLoggerImplementationLibraryName().toLowerCase().contains("log4j");
    }
    
    public boolean isLogbackImplementationBinded(){
    	return getLoggerImplementationLibraryName().toLowerCase().contains("logback");
    }
    
    public void writeLog() {
    	getLogger().debug("HIHIHI");
    }
}
