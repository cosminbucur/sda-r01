package com.sda.spring.boot.editor;

import org.springframework.stereotype.Component;

@Component
public class TextFormatter {

    public String format() {
        System.out.println("formatting...");
        return "format";
    }
}
