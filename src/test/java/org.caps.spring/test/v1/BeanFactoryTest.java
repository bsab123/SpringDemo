package org.caps.spring.test.v1;

import org.caps.spring.bean.BeanDefinition;
import org.caps.spring.bean.factory.BeanCreationException;
import org.caps.spring.bean.factory.BeanDefinitionStoreException;
import org.caps.spring.bean.factory.BeanFactory;
import org.caps.spring.bean.factory.support.DefaultBeanFactory;
import org.caps.spring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * @author Caps.Xia
 */
public class BeanFactoryTest {
    @Test
    public void testGetBean(){
        BeanFactory factory=new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd=factory.getBeanDefinition("petStore");
        assertEquals("org.caps.spring.service.v1.PetStoreService",bd.getBeanClassName());
        PetStoreService petStoreService=(PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);
    }
    @Test
    public void testInvalidBean(){
        BeanFactory factory=new DefaultBeanFactory("petstore-v1.xml");
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }
        Assert.fail("expect BeanCreationException");
    }

    public void testInvalidXml(){
        try {
            new DefaultBeanFactory("xxx.xml");
        } catch (BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException");
    }
}
