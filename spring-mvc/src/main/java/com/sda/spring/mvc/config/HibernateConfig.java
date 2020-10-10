package com.sda.spring.mvc.config;

import com.sda.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

    // autowire application context
    @Autowired
    private ApplicationContext context;

    // create session factory bean
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        // load properties from xml file into config object
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));

        // annotate entities
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }

    // create transaction manager
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        // use the session factory bean
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
