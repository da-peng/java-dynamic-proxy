package com.qlchat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author grabbywu
 * @Title: java-dynamic-proxy
 * @Package com.qlchat
 * @Description: todo
 * @date 5/28/184:50 PM
 */
public class ProxyFactoryTest {

    @Test
    public void testJDKProxyFactory(){
        // write your code here
        // 目标对象
        IUSerDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        IUSerDao proxy = (IUSerDao) new JDKProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        //  执行方法   【代理对象】
        proxy.save();
    }

    @Test
    public void testCglibProxyFactory(){
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new CglibProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();

    }
}