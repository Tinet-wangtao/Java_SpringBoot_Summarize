package com.wt.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wt.aspect.HttpAspect;
import com.wt.entity.Girl;
import com.wt.repository.GirlRepository;
import com.wt.service.GirlService;

/**
 * 
 * @author hohoTT
 * 
 *
 */

@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

	
	/**
	 * 查询所有的女生列表
	 * 
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		
		logger.info("logger.info this is girlList function!");
		
		return girlRepository.findAll();

	}

	/**
	 * 添加一个女生的方法
	 * 
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {

		Girl girl = new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);

		return girlRepository.save(girl);
	}
	
	/**
	 * 优雅的添加一个女生的方法，简化复杂参数的冗余
	 * 
	 * @return
	 */
	// 添加进行对girl进行验证
	// 将返回的结果放入到bindingResult对象中
	@PostMapping(value = "/girlsAddNew")
	public Girl girlAddNew(@Valid Girl girl, BindingResult bindingResult){
//		girl.setCupSize(girl.getCupSize());
//		girl.setAge(girl.getAge());

		// 如果验证错误，将把错误的信息打印出来
		// 此时打印的错误信息为 Girl 实体类中对age进行Min验证限制时写入的错误信息
		if(bindingResult.hasErrors()){
			System.out.println("bindingResult error message : " + bindingResult.getFieldError().getDefaultMessage());
			
			// 既然发生了错误，那么就应该不继续接下来的逻辑
			return null;
			
		}
		
		return girlRepository.save(girl);
	}

	/**
	 * 根据Id查询女生
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id);
	}

	/**
	 * 更新女生信息
	 * 
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/girls/{id}")
	public Girl updateGirl(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}

	/**
	 * 删除ID
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/girls/{id}")
	public void updateGirl(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}
	
	
	/**
	 * 通过年龄查询女生列表
	 * 
	 * @return
	 */
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> giListByAge(@PathVariable("age") Integer age) {

		return girlRepository.findByAge(age);

	}

	@PostMapping(value = "/girls/insertTwo")
	public void girlTwo(){
		girlService.insertTwo();
	}
	
}
