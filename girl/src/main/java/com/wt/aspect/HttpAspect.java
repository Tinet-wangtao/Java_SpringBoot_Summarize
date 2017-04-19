package com.wt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * AOP 部分的介绍
 * 
 * @author hohoTT
 *
 */

@Aspect
@Component
public class HttpAspect {

	// 添加日志属性
	// 注意此时引入的包为org.slf4j下的Logger
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	// 首先测试拦截GirlController.java中的girlList方法
	// girlList(..) 其中的..表示不管传递到girlList方法参数有多少，都将会进行拦截
	// execution(public * com.wt.controller.GirlController.*(..))
	// 这上边中的*表示此时会拦截GirlController下所有的方法
	// @Before("execution(public * com.wt.controller.GirlController.*(..))")
	// public void doBefore(){
	// System.out.println(11111111);
	// }
	//
	//
	// @After("execution(public * com.wt.controller.GirlController.*(..))")
	// public void doAfter(){
	// System.out.println(22222222);
	// }

	// 定义一个公共的方法，减少代码的冗余
	// @Pointcut("execution(public * com.wt.controller.GirlController.*(..))")
	// public void log() {
	// }
	//
	// @Before("log()")
	// public void doBefore() {
	// logger.info("logger.info " + " 1111111111111");
	// }
	//
	// @After("log()")
	// public void doAfter() {
	// logger.info("logger.info " + " 222222222222");
	// }

	// 定义一个公共的方法，减少代码的冗余
	@Pointcut("execution(public * com.wt.controller.GirlController.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("logger.info " + " 1111111111111");

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// url
		logger.info("url={}", request.getRequestURL());
		// method
		logger.info("method={}", request.getMethod());

		// ip
		logger.info("ip={}", request.getRemoteAddr());

		// 类方法
		logger.info("class_method={}",
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

		// 参数
		logger.info("args={}", joinPoint.getArgs());
	}

	@After("log()")
	public void doAfter() {
		logger.info("logger.info " + " 222222222222");
	}

	// 获取返回的参数
	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturning(Object object) {
		logger.info("response={}", object.toString());
	}

}
