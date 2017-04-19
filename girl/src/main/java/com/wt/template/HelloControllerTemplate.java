package com.wt.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wt.model.GirlProperties;

/**
 * 
 * @author hohoTT 模板使用类，去除 @RestController 使用 @Controller
 *
 */
@Controller
public class HelloControllerTemplate {

	// 使用model一个整体的类来进行注入的代码示例，区别去之前配置文件中单个属性值添加注入的繁琐
	@Autowired
	private GirlProperties girlProperties;

	@RequestMapping(value = "/helloTemplate", method = RequestMethod.GET)
	public String Hello() {
		// 呈现打印model中属性的结果
//		return "cupSize : " + girlProperties.getCupSize() + " age : " + girlProperties.getAge();
	
		return "templateIndex";
	}

}
