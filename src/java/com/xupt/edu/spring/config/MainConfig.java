package com.xupt.edu.spring.config;

import com.xupt.edu.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
//配置类=配置文件
@Configuration //告诉spring这是一个配置类
@ComponentScan(value = "com.xupt.edu.spring",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
//@ComponentScan value 指定要扫描的包
// excludeFilters  Filter[]  扫描时要
public class MainConfig
{
    //给容器中注册一个Bean;类型为返回值的类型,id默认是用方法名做id
    @Bean(value = "person")
    public Person person1 ()
    {
        return new Person("lisi",20);
    }
}
