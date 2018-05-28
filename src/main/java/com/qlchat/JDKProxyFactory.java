package com.qlchat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author grabbywu
 * @Title: java-dynamic-proxy
 * @Package com.qlchat
 * @Description:  创建动态代理对象，动态代理不需要实现接口，但是需要指定接口类型
 * @date 5/28/183:49 PM
 */
public class JDKProxyFactory {
    //维护一个目标对象
    private  Object target;

    public JDKProxyFactory(Object target){
        this.target = target;
    }
//    给目标对象生成代理对象
    public Object getProxyInstance(){

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务2");
                        return returnValue;

                    }
                }

        );
    }
}
