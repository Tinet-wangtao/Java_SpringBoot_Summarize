package com.wt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wt.entity.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer>{
	
	// 添加一个按照年龄查询的方法
	// 特别要注意的是方法名的书写方式
	public List<Girl> findByAge(Integer age);

}
