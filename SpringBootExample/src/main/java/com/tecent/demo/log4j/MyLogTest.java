package com.tecent.demo.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogTest {
    private static final Logger log = LoggerFactory.getLogger(MyLogTest.class);

    public static void main(String[] args) {
        log.info("test-> info");
        log.debug("test-> debug");
        log.warn("test-> warn");
        log.error("test-> error");
    }
}
