package com.xupt.edu.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
public class ColorFactoryBean  implements FactoryBean{
    //返回
    @Nullable
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
