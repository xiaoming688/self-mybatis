package com.myself.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class MyConfiguration {


    public static final ResourceBundle sqlMapping;

    static{
        sqlMapping = ResourceBundle.getBundle("v1sql");
    }

    /**
     * 返回接口的代理对象
     *
     * @param clazz
     * @param mySqlSession
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz, MySqlSession mySqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MyMapperProxy(mySqlSession));
    }
}
