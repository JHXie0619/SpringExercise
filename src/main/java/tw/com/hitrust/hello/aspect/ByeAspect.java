package tw.com.hitrust.hello.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ByeAspect {
	
	long time = 0;
	
	@Pointcut("execution(* tw.com.hitrust.*.controller.*.create(..)) ||execution(* tw.com.hitrust.*.controller.*.delete(..))")
	public void pointCut() {
	}
	
	@Around("pointCut()")
	public void doAround(ProceedingJoinPoint joinPoint) {
		
		time = System.currentTimeMillis();
		log.info("bye,@Around");
		try {
			Object rtn = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		time = System.currentTimeMillis()-time;
		log.info("bye again,@Around 執行時間={}毫秒",time);
	}
}
