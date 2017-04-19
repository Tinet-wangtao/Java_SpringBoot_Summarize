package com.wt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wt.model.GirlProperties;

/**
 * 
 * @author hohoTT
 *
 */
@RestController
@RequestMapping("/hi")
public class HelloController {
	
	// 以下为使用普通注入进行的测试
	/*
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
	*/
	
	
	// 使用model一个整体的类来进行注入的代码示例，区别去之前配置文件中单个属性值添加注入的繁琐
	@Autowired
	private GirlProperties girlProperties;
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {
		// 呈现打印model中属性的结果
		return "cupSize : " + girlProperties.getCupSize() 
		+ " age : " + girlProperties.getAge(); 
	}

	@RequestMapping(value = {"/mappingOne", "/mappingTwo"}, method = RequestMethod.GET)
	public String TwoMapping() {
		// 呈现打印model中属性的结果
		return "/mappingOne & Two" + "cupSize : " + girlProperties.getCupSize() 
		+ " age : " + girlProperties.getAge(); 
	}
}
