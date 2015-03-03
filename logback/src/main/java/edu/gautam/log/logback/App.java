package edu.gautam.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger slf4jLogger = LoggerFactory.getLogger(App.class);
	 
	private static ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
	 
    /**
     * @param args
     */
    public static void main(String[] args) {
        slf4jLogger.trace("Hello World!");
         
        String name = "Sia";
        
        root.setLevel(Level.TRACE);
        System.out.println(bunchOfLogStatements(name));
        
        root.setLevel(Level.ERROR);
        System.out.println("Logger set to ERROR");
        System.out.println(bunchOfLogStatements(name));
    }

	private static long bunchOfLogStatements(String name) {
		long nanoTime = System.nanoTime();
		slf4jLogger.debug("Hi, {}", getName(name));
        slf4jLogger.info("Welcome to the HelloWorld example of Logback.");
        slf4jLogger.warn("Dummy warning message.");
        slf4jLogger.error("Dummy error message.");
        return nanoTime -= System.nanoTime();
	}
    
    private static String getName(String name) {
    	System.out.println("getName called for logger level: " + root.getEffectiveLevel());
    	try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
    	return name;
    }
}
