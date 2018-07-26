package com.xupt.edu.spring.test;

import com.xupt.edu.spring.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
public class IOCTest {
    @Test
    @SuppressWarnings("resource")
    public void test1()
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String bean:names
             ) {
            System.out.println(bean);
        }
    }
}
