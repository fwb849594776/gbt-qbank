package com.fitt.gbt.qbank.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>@Description: 实体Bean工具类</p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-05-22</p>
 * <p>@version: 1.0</p>
 */
public abstract class BeanUtil extends org.springframework.beans.BeanUtils {
    /**
     * 获取实体Bean中空值的字段数组
     *
     * @param source
     * @return
     */
    public static void copyProperties(Object source, Object target) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
                        if (value != null) {
                            Method writeMethod = targetPd.getWriteMethod();
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                    } catch (Throwable ex) {
                        throw new FatalBeanException("Could not copy properties from source to target", ex);
                    }
                }
            }
        }
    }

    /**
     * Bean 转成 Map
     *
     * @param bean 类对象
     * @return Map<String   ,       Object>
     */
    public static Map<String, Object> bean2Map(Object bean) {
        if (null == bean) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>(16);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (null != propertyDescriptors && propertyDescriptors.length > 0) {
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    String key = propertyDescriptor.getName();
                    if (!"class".equals(key)) {
                        Method readMethod = propertyDescriptor.getReadMethod();
                        Object value = readMethod.invoke(bean);
                        map.put(key, value);
                    }
                }
            }
        } catch (Throwable e) {
            throw new FatalBeanException("Bean convert to Map failed.", e);
        }
        return map;
    }

    /**
     * Map 转成 Bean
     *
     * @param map   Map<String, Object>
     * @param clazz 类
     * @return T 类对象
     */
    public static <T extends Object> T map2Bean(Map<String, Object> map, Class<T> clazz) {
        if (null == map || map.isEmpty()) {
            return null;
        }

        T instance = null;
        try {
            instance = clazz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (null != propertyDescriptors && propertyDescriptors.length > 0) {
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    String key = propertyDescriptor.getName();
                    if (map.containsKey(key)) {
                        Object value = map.get(key);
                        Method writeMethod = propertyDescriptor.getWriteMethod();
                        writeMethod.invoke(instance, value);
                    }
                }
            }
        } catch (Throwable e) {
            throw new FatalBeanException("Map convert to Bean failed.", e);
        }

        return instance;
    }
}
