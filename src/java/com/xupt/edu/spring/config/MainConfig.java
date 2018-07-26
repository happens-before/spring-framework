package com.xupt.edu.spring.config;

import com.xupt.edu.spring.Service.BookService;
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
@ComponentScan(value = "com.xupt.edu.spring",useDefaultFilters = false,
        includeFilters = {//@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
})
//@ComponentScan value 指定要扫描的包
// excludeFilters  Filter[]  指定扫描的时候按照什么规则排除什么组件
//includeFilters  Filter[]   扫描时只扫描哪些组件
// FilterType.ANNOTATION      按照注解
// FilterType.ASSIGNABLE_TYPE,按照给定的类型
// FilterType.ASPECTJ,        使用ASPECTJ表达式
// FilterType.REGEX,          使用正则表达式
// FilterType.CUSTOM;         使用自定义规则
public class MainConfig
{
    //给容器中注册一个Bean;类型为返回值的类型,id默认是用方法名做id
    @Bean(value = "person")
    public Person person1 ()
    {
        return new Person("lisi",20);
    }

}
