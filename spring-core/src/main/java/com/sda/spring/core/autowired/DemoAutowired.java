package com.sda.spring.core.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoAutowired {

    public static void main(String[] args) {
        ApplicationContext appContext =
            new AnnotationConfigApplicationContext(AutowiredConfig.class);

        TextEditor textEditor = appContext.getBean("textEditor", TextEditor.class);

        textEditor.spellCheck();
        textEditor.format();
        textEditor.convert();
    }
}
