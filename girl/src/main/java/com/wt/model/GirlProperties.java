package com.wt.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author hohoTT Girl model
 *
 */
@Component // 添加注入配置中不可缺少这个属性，没用的话会提示找不到这个指定的类
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

	private String cupSize;

	private Integer age;

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
