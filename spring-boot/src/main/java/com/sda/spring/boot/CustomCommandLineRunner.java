package com.sda.spring.boot;

import com.sda.spring.boot.editor.TextEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CustomCommandLineRunner.class);

    @Autowired
    private MyComponent myComponent;

    @Autowired
    private TextEditor textEditor;

    @Override
    public void run(String... args) {
        // call my component
        logger.info("--- in custom command line runner");
//        myComponent.complexOperation();

        textEditor.checkAll();
    }
}
