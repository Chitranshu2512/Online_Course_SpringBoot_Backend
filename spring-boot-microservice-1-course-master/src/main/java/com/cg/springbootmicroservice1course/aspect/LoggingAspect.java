package com.cg.springbootmicroservice1course.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.cg.springbootmicroservice1course.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("➡️ Entering: {}", joinPoint.getSignature().toShortString());
        logger.debug("🔸 Arguments: {}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.cg.springbootmicroservice1course.service..*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        logger.info("✅ Exiting: {}", joinPoint.getSignature().toShortString());
        logger.debug("🔸 Returned: {}", result);
    }

    @AfterThrowing(pointcut = "execution(* com.cg.springbootmicroservice1course.service..*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.error("❌ Exception in {}: {}", joinPoint.getSignature().toShortString(), ex.getMessage(), ex);
    }
}
