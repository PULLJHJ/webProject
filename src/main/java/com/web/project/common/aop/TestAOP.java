package com.web.project.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class TestAOP {

	// 해당 패키지의 모든 메소드에 pointcut
	@Pointcut("execution(* com.web.project..*Controller.*(..))")
	public void controllerCut() {}

	// 메소드 실행하기 바로 전
	@Before("controllerCut()")
	public void beforeController(JoinPoint jp) {
		log.info("before=>{}", jp.getSignature().getName());
	}

	// 메소드 실행 직후
	@After("controllerCut()")
	public void afterController(JoinPoint jp) {
		log.info("after=>{}", jp.getSignature().getName());
	}

	// proceed 순간 메소드가 실행됨
	@Around("controllerCut()")
	public Object aroundController(ProceedingJoinPoint pjp) throws Throwable {
		log.info("around before=>{}", pjp.getSignature().getName());
		Object obj = pjp.proceed();
		log.info("around after=>{}", pjp.getSignature().getName());
		return obj;
	}
}
