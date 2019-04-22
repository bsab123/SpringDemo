package org.caps.spring.bean;

/**
 * @Author: caps
 * @Date: 2019/4/22 16:12
 * @Version 1.0
 */
public class BeanException extends RuntimeException {
    public BeanException(String message) {
        super(message);
    }
    public BeanException(String message,Throwable cause) {
        super(message,cause);
    }

}
