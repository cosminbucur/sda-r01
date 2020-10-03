package com.sda.spring.boot.editor;

import org.springframework.stereotype.Component;

@Component
public class ImageConverter {

    public String convert() {
        System.out.println("converting...");
        return "convert";
    }
}
