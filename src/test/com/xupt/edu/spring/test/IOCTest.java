package com.xupt.edu.spring.test;

import com.xupt.edu.spring.bean.Person;
import com.xupt.edu.spring.config.MainConfig;
import com.xupt.edu.spring.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
public class IOCTest {
    AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfig2.class);
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
    @Test
    @SuppressWarnings("resource")
    public void test2()
    {
        //创建IOC容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] names = applicationContext.getBeanDefinitionNames();
//        for (String bean:names
//                ) {
//            System.out.println(bean);
//        }
          System.out.println("IOC容器创建完成..");
          //默认是单实例的
          Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
//        System.out.println(person==person2);
    }
    @Test
    public void test03()
    {
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment=applicationContext.getEnvironment();
        //windows10
        String property=environment.getProperty("os.name");
        System.out.println(property);
        for (String name:namesForType
             ) {
            System.out.println(name);
        }
        Map<String, Person> type = applicationContext.getBeansOfType(Person.class);
        System.out.println(type);
    }
}
