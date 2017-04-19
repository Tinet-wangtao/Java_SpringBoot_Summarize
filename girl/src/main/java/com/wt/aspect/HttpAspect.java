package com.wt.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * AOP 部分的介绍
 * @author hohoTT
 *
 */

@Aspect
@Component
public class HttpAspect {

	// 首先测试拦截GirlController.java中的girlList方法
	// girlList(..) 其中的..表示不管传递到girlList方法参数有多少，都将会进行拦截
	// execution(public * com.wt.controller.GirlController.*(..))
	// 这上边中的*表示此时会拦截GirlController下所有的方法
	@Before("execution(public * com.wt.controller.GirlController.*(..))")
	public void log(){
		System.out.println(11111111);
	}
	
}
