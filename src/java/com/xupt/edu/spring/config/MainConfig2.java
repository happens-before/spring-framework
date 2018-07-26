package com.xupt.edu.spring.config;

import com.xupt.edu.spring.bean.Color;
import com.xupt.edu.spring.bean.Person;
import com.xupt.edu.spring.bean.Red;
import com.xupt.edu.spring.condition.LinuxCondition;
import com.xupt.edu.spring.condition.MyImportSelector;
import com.xupt.edu.spring.condition.WindowCondition;
import org.springframework.context.annotation.*;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class})
//@Import导入组件，id默认为类全名
public class MainConfig2 {
    //prototype:多实例的:IOC容器启动并不会去调用方法创建对象放在容器中，每次获取对象的税后才会调用方法创建对象 。
    //singleton:单实例的(默认的)：IOC容器启动会调用方法创建对象放到ioc容器中，以后每次获取都直接从容器（map.get()）里拿
    // request:同一个请求创建一个实例
    //session:同一个session创建一个实例

    /**
     * 懒加载：
     *         单实例bean：默认在容器启动的时候创建对象
     *         懒加载：容器启动的时候不创建对象，而在第一次使用（获取）bean对象时创建对象，并初始化。
     */

    //@Scope(value = "prototype")
    @Lazy
    @Bean
    public Person person()
    {
        System.out.println("给容器中添加Person...");
        return new Person("zhaowanyue",17);
    }

    /**
     * @Conditional({Conditional}):按照一定的条件进行判断，满足条件给容器中注册bean
     * 如果系统是windows，给容器注册@Bean("bill")
     * 如果系统是，给容器注册@Bean("linus")
     */
    @Conditional({WindowCondition.class})
    @Bean("bill")
    public Person person1()
    {
        return new Person("Bill Gate",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person2()
    {
        return new Person("linus",48);
    }

    /**
     * 给容器注册组件的方法：
     * 1.包扫描+组件标注注解（@Controller,@Service,@Respository,@Component)
     * 2.@Bean[导入的第三方包里面的组件]
     * 3.@Import[快速给容器中导入一个组件]
     *  3.1.@Import（要导入到容器中的组件）；容器中就会自动注册这个组件，id默认是全类名
     *  3.2.ImportSelector:返回需要导入的组件的全类数组。
     */
}
