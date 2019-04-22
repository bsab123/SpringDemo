package org.caps.spring.bean.factory.support;

import org.caps.spring.bean.BeanDefinition;
import org.caps.spring.bean.factory.BeanCreationException;
import org.caps.spring.bean.factory.BeanDefinitionStoreException;
import org.caps.spring.bean.factory.BeanFactory;

/**
 * @author Caps.Xia
 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory  implements BeanFactory {
    public static final String ID_ATTRIBUTE="id";
    public static final String CLASS_ATTRIBUTE="class";
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public DefaultBeanFactory(String confileFile) {
        loadBeanDefinition(confileFile);
    }

    private void loadBeanDefinition(String confileFile) {
        InputStream is=null;
        try {
            ClassLoader loader = ClassUtils.getDefaultClassLoader();
            is = loader.getResourceAsStream(confileFile);

            SAXReader reader=new SAXReader();
            Document document = reader.read(is);
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()){
                Element element = iterator.next();
                String id = element.attributeValue(ID_ATTRIBUTE);
                String beanClassName= element.attributeValue(CLASS_ATTRIBUTE);
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition(id, beanClassName);
                this.beanDefinitionMap.put(id,beanDefinition);

            }
        } catch (DocumentException e) {
            throw new BeanDefinitionStoreException("create bean for",null);
        }finally {
            if(is!=null){
                try{
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public BeanDefinition getBeanDefinition(String beanID) {
        return this.beanDefinitionMap.get(beanID);
    }

    @Override
    public Object getBean(String beanID) {
        BeanDefinition bd=this.getBeanDefinition(beanID);
        if(bd==null){
            throw new BeanCreationException("Bean Definition does not exist");
        }
        ClassLoader c1 = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();

        try{
            Class<?> aClass = c1.loadClass(beanClassName);
            return aClass.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for"+beanClassName+"");
        }
    }
}