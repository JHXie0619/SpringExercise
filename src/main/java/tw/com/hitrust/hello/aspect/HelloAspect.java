package tw.com.hitrust.hello.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;
import tw.com.hitrust.hello.annotation.Hello;

@Component
@Aspect
@Slf4j
public class HelloAspect {
	
	ServletRequestAttributes attributes = null;
	HttpServletRequest request = null;
	@Pointcut("execution(* tw.com.hitrust.*.controller.*.*(..))")
	public void pointCut() {
	} 
	@Pointcut("execution(* tw.com.hitrust.*.controller.*.create(..))||execution(* tw.com.hitrust.*.controller.*.update(..))")
	public void pointCutCU() {
	} 
	
	@Before("pointCutCU()")
	public void  doBefore(JoinPoint joinPoint) throws JsonProcessingException {
		
			attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
			request = attributes.getRequest();
			Object[] args = joinPoint.getArgs();
			Object object = args[0];
			JSONObject jsonObject = (JSONObject)JSON.toJSON(object);
			
			ObjectWriter ow = new ObjectMapper().setSerializationInclusion(Include.NON_NULL).writer().withDefaultPrettyPrinter();
			String jsonRes = ow.writeValueAsString(object);
			log.info("hello,@Before RESPONSE: {}",jsonRes);
	}
	
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Hello hello = method.getAnnotation(Hello.class);
		String msg = hello != null ? "hello":"bye";
		
		log.info(msg+"@After");
	}
	
	@AfterReturning("pointCut()")
	public void doAfterReturning(JoinPoint joinPoint) {
		log.info("hello,@AfterReturning");
	}
	
}
