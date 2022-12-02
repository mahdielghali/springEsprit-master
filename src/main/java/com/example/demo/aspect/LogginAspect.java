package com.example.demo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.logging.LogManager;

@Slf4j
@Aspect
@Component
public class LogginAspect {

    /*private  static  final Logger logger = LogManager.getLogger(LogginAspect.class);*/

    @Before("execution(* com.example.demo.service.*.*(..))")
    public  void logMethodEntry(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @AfterReturning(" execution(* com.example.demo.service.*.add*(..))")
    public void LogMethodShow(JoinPoint joinPoint){
        log.info("Ajouté!");
    }


}
