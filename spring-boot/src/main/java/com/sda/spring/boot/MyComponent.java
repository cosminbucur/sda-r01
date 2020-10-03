package com.sda.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MyComponent {

    // TODO: use log4j2 / slf4j as a logging framework
    private static final Logger logger = LoggerFactory.getLogger(MyComponent.class);

    public void complexOperation() {
        logger.info("--- in complex operation");
        logger.debug("--- in complex operation");
        logger.warn("--- in complex operation");
        logger.error("--- in complex operation");
    }
}
