package org.caps.spring.bean.factory;

import org.caps.spring.bean.BeanException;

/**
 * @Author: caps
 * @Date: 2019/4/22 16:12
 * @Version 1.0
 */
public class BeanCreationException extends BeanException {
    private String beanName;
    public BeanCreationException(String msg) {
        super(msg);
    }
    public BeanCreationException(String message, Throwable cause) {
        super(message,cause);
    }
    public BeanCreationException(String beanName, String msg) {
        super("Error creating bean with name'"+beanName+"':"+msg);
        this.beanName=beanName;
    }
    public BeanCreationException(String beanName, String msg,Throwable cause) {
        this(beanName,msg);
        initCause(cause);
    }
    public String getBeanName(){
        return this.beanName;
    }

}
