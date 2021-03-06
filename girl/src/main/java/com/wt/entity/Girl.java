package com.wt.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author hohoTT Girl 实体类
 *
 */

// 添加注解，相当于数据库中的一个表
@Entity
public class Girl {

	// id 以及自增的属性
	@Id
	@GeneratedValue
	private Integer id;

	private String cupSize;

	@Min(value = 18, message = "未成年不得入内！")
	private Integer age;

	// 设置为该字段不为空，为必填字段
	@NotNull(message = "金额必传")
	private Double money;

	public Girl() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	// 添加一个toString方法
	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + ", money=" + money + "]";
	}

}
