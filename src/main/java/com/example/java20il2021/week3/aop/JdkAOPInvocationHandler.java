package com.example.java20il2021.week3.aop;


import com.example.java20il2021.week3.aop.advice.After;
import com.example.java20il2021.week3.aop.advice.Around;
import com.example.java20il2021.week3.aop.advice.Before;
import com.example.java20il2021.week3.aop.interceptor.AfterMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.AroundMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.BeforeMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.MethodInterceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JdkAOPInvocationHandler implements InvocationHandler {

    private Object originObj;
    private AdvisedSupport advisedSupport;

    public JdkAOPInvocationHandler(Object originObj, AdvisedSupport advisedSupport) {
        this.originObj = originObj;
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        Class<?> aspectClass = aspectObj.getClass();
//        List<MethodInterceptor> interceptors = new ArrayList<>();
//        for(Method aspectMethod: aspectClass.getDeclaredMethods()) {
//            for(Annotation ano: aspectMethod.getDeclaredAnnotations()) {
//                MethodInterceptor methodInterceptor = null;
//                if(ano.annotationType() == Before.class) {
//                    methodInterceptor = new BeforeMethodInterceptor(aspectObj, aspectMethod);
//                } else if(ano.annotationType() == After.class) {
//                    methodInterceptor = new AfterMethodInterceptor(aspectObj, aspectMethod);
//                } else if(ano.annotationType() == Around.class) {
//                    methodInterceptor = new AroundMethodInterceptor(aspectObj, aspectMethod);
//                }
//                interceptors.add(methodInterceptor);
//            }
//        }
        MethodInvocation mi = new ProxyMethodInvocation(advisedSupport.getInterceptors(method), originObj, method, args);
        return mi.proceed();
    }
}