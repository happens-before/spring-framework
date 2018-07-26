package com.xupt.edu.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
public class WindowCondition implements Condition{
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //是否Windows系统
        //1.能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2.获取类的加载器
        final ClassLoader classLoader = conditionContext.getClassLoader();
        //3获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //4获取到bean的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        String property = environment.getProperty("os.name");
        if(property.contains("Windows"))
        {
            return true;
        }
        return false;
    }
}
