package org.caps.spring.bean.factory.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.caps.spring.bean.BeanDefinition;


/**
 * @Author: caps
 * @Date: 2019/4/22 11:44
 * @Version 1.0
 */

@Data
@AllArgsConstructor
public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;


}
