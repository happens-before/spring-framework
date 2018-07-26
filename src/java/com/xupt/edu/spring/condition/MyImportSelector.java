package com.xupt.edu.spring.condition;

import com.xupt.edu.spring.bean.Blue;
import com.xupt.edu.spring.bean.Yellow;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: zhaowanyue
 * @date: 2018/7/26
 * @description:
 */
public class MyImportSelector implements ImportSelector {

    //annotationMetadata：当前标注@Import注解的类的所有注解信息
    //返回值，就要要导入到容器中的组件全类名
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{ "com.xupt.edu.spring.bean.Blue","com.xupt.edu.spring.bean.Yellow"};
    }
}
