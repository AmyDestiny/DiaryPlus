package com.gentlehu.diary.helper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class OptionAspect {


    public void process(){

    }

    public void beforeOption(JoinPoint joinPoint){//操作前
        String name = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("操作前" + name +" 的 " + methodName);
    }
    public void afterOption(JoinPoint joinPoint){//操作之后
        System.out.println("操作之后");
    }
    public void afterReturnOption(){//方法正常结束并且返回之后
        System.out.println("方法正常结束并且返回之后");
    }
    public Object aroundOption(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知执行了");
//        Diary diary = new Diary();
//        diary.setId(123);
//        result = diary;
        return result;
    }
}
