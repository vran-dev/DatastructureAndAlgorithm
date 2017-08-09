package cc.cc1234.util;

import java.util.function.Supplier;

import org.slf4j.Logger;

/**
 * 日志工具类
 * 
 * @author vran
 *
 */
public class Log {
	
	public static void debug(Logger logger, Supplier<String> supplier) {
		if(logger.isDebugEnabled()) {
			logger.debug(supplier.get());
		}
	}
	
	public static void info(Logger logger,Supplier<String> supplier) {
		if(logger.isInfoEnabled()) {
			logger.info(supplier.get());
		}
	}
	
	public static void error(Logger logger, Supplier<String> supplier) {
		if(logger.isErrorEnabled()) {
			logger.error(supplier.get());
		}
	}
	
	public static void warn(Logger logger, Supplier<String> supplier) {
		if(logger.isWarnEnabled()) {
			logger.warn(supplier.get());
		}
	}
	
}
