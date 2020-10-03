package com.sda.spring.core.qualifier;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter implements Formatter {

    public FooFormatter() {
        System.out.println("in foo formatter constructor");
    }

    @Override
    public String format() {
        System.out.println("foo");
        return "foo";
    }
}
