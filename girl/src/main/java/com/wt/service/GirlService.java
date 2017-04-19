package com.wt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wt.entity.Girl;
import com.wt.repository.GirlRepository;

/**
 * 
 * @author why
 *
 */
@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	// 事物注解
	// 用于当一条插入失败的时候，另一条插入操作也不能正常进行
	@Transactional
	public void insertTwo(){
		Girl girlA = new Girl();
		girlA.setCupSize("K");
		girlA.setAge(66);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setCupSize("F");
		girlB.setAge(77);
		girlRepository.save(girlB);
	}

}
