package org.caps.spring.bean.factory;


import org.caps.spring.bean.BeanDefinition;
/**
 * @author Caps.Xia
 */
public interface BeanFactory {

    /**
     * @param beanID
     * @return
     */
    BeanDefinition getBeanDefinition(String beanID);

    /**
     * @param beanID
     * @return
     */
    Object getBean(String beanID);
}
