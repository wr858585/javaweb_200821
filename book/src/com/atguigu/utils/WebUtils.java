package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author oono
 * @date 2020 10 19
 */
public class WebUtils {

    //一次性把map中的数据都注入到Bean的属性值中
    public static <T> T copyParam2Bean(T bean, Map params){

        /*
        BeanUtils工具类中的populate()方法会把请求的map对象，一次性注入到指定的bean对象的对应属性中
        mechanism：通过使用map中key的值，找到bean中对一个的setXxx方法，传入value进行注入
        第一个参数bean：需要被注入的bean对象
        第二个参数params：要注入的键值对内容
         */

        try {
            BeanUtils.populate(bean, params);
            System.out.println("注入值之后 --> " + bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return bean;
    }
}
