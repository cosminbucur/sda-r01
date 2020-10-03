package com.sda.spring.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    // HAS A
    // binds formatter with the foo service
    @Autowired
    // selects the desired bean
    @Qualifier("fooFormatter")
    private Formatter formatter;

    public FooService() {
        System.out.println("in foo service");
    }

    public void run() {
        formatter.format();
    }
}
