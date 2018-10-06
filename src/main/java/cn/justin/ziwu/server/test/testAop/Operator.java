package cn.justin.ziwu.server.test.testAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Operator {

    @Pointcut("execution(* cn.justin.ziwu.server..*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("aop before advice");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinpoint) {
        System.out.println("aop after advice");
    }
}
