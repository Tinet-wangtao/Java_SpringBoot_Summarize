package com.wt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author hohoTT
 *
 */
@RestController
public class HelloController {
	
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

}
