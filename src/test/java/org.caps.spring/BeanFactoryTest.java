package org.caps.spring;

import org.caps.spring.bean.factory.BeanFactory;
import org.caps.spring.bean.factory.PetStoreService;
import org.caps.spring.bean.factory.support.DefaultBeanFactory;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeanFactoryTest {
    @Test
    public void testGetBean(){
        BeanFactory factory=new DefaultBeanFactory();
        BeanDefinition bd=factory.getBeanDefinition("petstore-v1.xml");
        assertEquals("PetStoreService",bd.getBeanClassName());
        PetStoreService petStoreService=(PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);
    }
}
