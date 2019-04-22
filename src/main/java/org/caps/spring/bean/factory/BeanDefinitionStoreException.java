package org.caps.spring.bean.factory;

import org.caps.spring.bean.BeanException;

/**
 * @Author: caps
 * @Date: 2019/4/22 16:12
 * @Version 1.0
 */
public class BeanDefinitionStoreException extends BeanException {
    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message,cause);
    }

}
