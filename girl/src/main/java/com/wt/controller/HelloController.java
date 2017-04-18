package com.wt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author hohoTT
 *
 */
@RestController
public class HelloController {
	
	@Value("${cupSize}")
	private String cupSize; // 配置文件中的属性注入到该文件中
	
	// 配置文件中不需要关心属性的类型，只需要在注入时进行声明即可
	// 以下属性的注入与之前的类似，以此类推
	@Value("${age}")
	private Integer age;
	
	// 另一种获取注入的形式，主要的区别在于yml配置文件
	// 如何在配置中写配置
	@Value("${content}")
	private String content;
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {
		// 此时打印的值应为 B
		return "以下为打印注入的属性值用来进行测试  " + "cupSize: " + cupSize
				+ "  age: " + age; 
	}
	
	@RequestMapping(value = "/helloContent", method = RequestMethod.GET)
	public String HelloContent(){
		return "content : " + content;
	}

}
