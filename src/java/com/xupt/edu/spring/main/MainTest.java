package com.xupt.edu.spring.main;

import com.xupt.edu.spring.bean.Person;
import com.xupt.edu.spring.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
public class MainTest {
    public static void main(String[]args)
    {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
//        Person bean= (Person) applicationContext.getBean("person");
//        System.out.println(bean);
          ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfig.class);
          Person bean= (Person) applicationContext.getBean(Person.class);
          System.out.println(bean);
          String[] name=applicationContext.getBeanNamesForType(Person.class);
        for (String beanName:name) {
            System.out.println(beanName);
        }
    }
}
