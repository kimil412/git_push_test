package com.ichatt.beagle.logstash.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

public class LogstashLoggerFactory {

    private static LogstashLoggerFactory instance = null;
    
    public static LogstashLoggerFactory getInstance() {
        if( instance == null ) {
            instance = new LogstashLoggerFactory();
        }

        return instance;
    }

    public Logger getLogger() {
    	return LoggerFactory.getLogger(LogstashLoggerFactory.class);
    }
    
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
}
