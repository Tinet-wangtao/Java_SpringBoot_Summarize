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
public class HelloController {
	
	// ����Ϊʹ����ͨע����еĲ���
	/*
	@Value("${cupSize}")
	private String cupSize; // �����ļ��е�����ע�뵽���ļ���
	
	// �����ļ��в���Ҫ�������Ե����ͣ�ֻ��Ҫ��ע��ʱ������������
	// �������Ե�ע����֮ǰ�����ƣ��Դ�����
	@Value("${age}")
	private Integer age;
	
	// ��һ�ֻ�ȡע�����ʽ����Ҫ����������yml�����ļ�
	// �����������д����
	@Value("${content}")
	private String content;
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {
		// ��ʱ��ӡ��ֵӦΪ B
		return "����Ϊ��ӡע�������ֵ�������в���  " + "cupSize: " + cupSize
				+ "  age: " + age; 
	}
	
	@RequestMapping(value = "/helloContent", method = RequestMethod.GET)
	public String HelloContent(){
		return "content : " + content;
	}
	*/
	
	
	// ʹ��modelһ���������������ע��Ĵ���ʾ��������ȥ֮ǰ�����ļ��е�������ֵ���ע��ķ���
	@Autowired
	private GirlProperties girlProperties;
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {
		// ���ִ�ӡmodel�����ԵĽ��
		return "cupSize : " + girlProperties.getCupSize(); 
	}

}
