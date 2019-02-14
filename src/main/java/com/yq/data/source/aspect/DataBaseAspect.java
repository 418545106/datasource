package com.yq.data.source.aspect;

import com.yq.data.source.annotation.DataBase;
import com.yq.data.source.config.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @auther: zpd
 * @Date: 2019/2/12 0012 10:30
 * @Description:
 */
@Aspect
@Component
public class DataBaseAspect {

    @Pointcut("@annotation(com.yq.data.source.annotation.DataBase)")
    public void dbPointCut(){}

    @Before("dbPointCut()")
    public void beforSwitchDataSource(JoinPoint point){
        //获得代理的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();

        String dataSource = DataSourceContextHolder.DEFAULT_DS;

        try {
            //  得到访问的方法对象
            Method method = className.getMethod(methodName,argClass);

            //判断是否存在@DataBase注解
            if(method.isAnnotationPresent(DataBase.class)){
                DataBase annotation = method.getAnnotation(DataBase.class);
                // 取出注解中的数据源名称
                dataSource = annotation.value();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("dbPointCut()")
    public void afterSwitchDataSource(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
