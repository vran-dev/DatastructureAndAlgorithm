package cc.cc1234.util;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 * 
 * @author vran
 *
 */
public class Log {
	private Logger logger;
	
	private Log(Logger logger) {
		this.logger = logger;
	}
	
	public static Log getInstance(Class<?> clazz) {
		return new Log(LoggerFactory.getLogger(clazz));
	}
	
	public void debug(Supplier<String> supplier) {
		if(logger.isDebugEnabled()) {
			logger.debug(supplier.get());
		}
	}
	
	public void info(Supplier<String> supplier) {
		if(logger.isInfoEnabled()) {
			logger.info(supplier.get());
		}
	}
	
	public void error(Supplier<String> supplier) {
		if(logger.isErrorEnabled()) {
			logger.error(supplier.get());
		}
	}
	
	public void warn(Supplier<String> supplier) {
		if(logger.isWarnEnabled()) {
			logger.warn(supplier.get());
		}
	}
	
}
