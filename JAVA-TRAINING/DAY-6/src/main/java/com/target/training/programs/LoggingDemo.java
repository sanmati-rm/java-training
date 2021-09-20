package com.target.training.programs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggingDemo {

    public final static Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {
        log.trace("This is a trace message");
        log.debug("this is a debug message");
        log.info("this is a info message");
        log.warn("this is a warn message");
        log.error("this is a error message");

    }
}
