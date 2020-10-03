package com.sda.spring.core.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoScope {

    public static void main(String[] args) {
        // create context
        ApplicationContext appContext
            = new AnnotationConfigApplicationContext(ScopeConfig.class);

        createPrototypes(appContext);
        createSingleton(appContext);
    }

    private static void createSingleton(ApplicationContext appContext) {
        SingletonService singletonService1 =
            appContext.getBean("singletonService", SingletonService.class);
        SingletonService singletonService2 =
            appContext.getBean("singletonService", SingletonService.class);
        System.out.println(singletonService1);
        System.out.println(singletonService2);
    }

    private static void createPrototypes(ApplicationContext appContext) {
        PrototypeService prototypeService1 =
            appContext.getBean("prototypeService", PrototypeService.class);
        PrototypeService prototypeService2 =
            appContext.getBean("prototypeService", PrototypeService.class);
        System.out.println(prototypeService1);
        System.out.println(prototypeService2);
    }


}
