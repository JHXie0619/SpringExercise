package tw.com.hitrust.hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class HelloAspect {
	
	@Pointcut("execution(* tw.com.hitrust.*.controller.*.*(..))")
	public void pointCut() {
	}
	
	@Before("pointCut()")
	public void  doBefore(JoinPoint joinPoint) {
		log.info("hello,@Before");
	}
	
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		log.info("hello,@After");
	}
	
	@AfterReturning("pointCut()")
	public void doAfterReturning(JoinPoint joinPoint) {
		log.info("hello,@AfterReturning");
	}
	
}
