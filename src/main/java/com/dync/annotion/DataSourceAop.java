package com.dync.annotion;

import com.dync.config.DateSourceContxtLocal;
import com.dync.util.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author liujipeng
 * @date 2020/8/11 15:32
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */

@Aspect
@Component
public class DataSourceAop {

    @Aspect
    @Component
    public class DataBaseAspect {

        @Pointcut("execution(public * com.dync.service..*.*(..))")
        public void dataExecution() {

        }

        @Around(value = "dataExecution()")
        public Object process(ProceedingJoinPoint point) throws Throwable {

            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            Class<?> clazz = point.getTarget().getClass();
            Throwable currentThrowable = null;
            Object object = null;
            try {
                method = clazz.getMethod(method.getName(), method.getParameterTypes());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Master master = AnnotationUtils.findAnnotation(method, Master.class);
            if (master != null) {
                DateSourceContxtLocal.setDate(DataSource.MASTER.getDesc());
            }
            try {
                object = point.proceed(point.getArgs());
            } catch (Throwable t) {
                currentThrowable = t;
            } finally {
                if (DateSourceContxtLocal.getDate() != null) {
                    DateSourceContxtLocal.clean();
                }
                if (currentThrowable != null) {
                    throw currentThrowable;
                }
            }
            return object;
        }

    }
}
