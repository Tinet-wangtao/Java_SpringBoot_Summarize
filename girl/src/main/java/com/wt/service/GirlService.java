package com.wt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wt.Exception.GirlException;
import com.wt.entity.Girl;
import com.wt.eums.ResultEnum;
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
	public void insertTwo() {
		Girl girlA = new Girl();
		girlA.setCupSize("K");
		girlA.setAge(66);
		girlRepository.save(girlA);

		Girl girlB = new Girl();
		girlB.setCupSize("F");
		girlB.setAge(77);
		girlRepository.save(girlB);
	}

	// 通过年龄获取一个对象，之后对获取的对象进行判断
	// 这里不推荐采用统一的返回值的格式，可以通过抛异常的方式进行，之后异常的处理在controller中进行
	public void getAge(Integer id) throws GirlException {
		Girl girl = girlRepository.findOne(id);

		System.out.println("33333333333333333" + girl);

		Integer age = girl.getAge();

		System.out.println("4444444444  " + age);

		if (age < 10) {
			// 返回小学阶段
			System.out.println("age < 10");
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		} else if (age >= 10 && age < 16) {
			// 返回初中阶段
			System.out.println("age >= 10 && age < 16");
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		} else {
			System.out.println("age >= 16");
			throw new GirlException(ResultEnum.MID_AGE);
		}

	}

	/**
	 * 通过Id查询一个女生的信息
	 * 
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id) {
		return girlRepository.findOne(id);
	}

}
