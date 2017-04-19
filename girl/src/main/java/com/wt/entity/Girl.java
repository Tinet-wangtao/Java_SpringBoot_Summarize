package com.wt.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	private Integer age;

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

}
