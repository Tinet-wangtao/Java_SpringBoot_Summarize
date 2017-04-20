package com.wt.girlTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wt.entity.Girl;
import com.wt.service.GirlService;

/**
 * Created by hohoTT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

	@Autowired
	private GirlService girlService;

	@Test
	public void findOneTest() {
		Girl girl = girlService.findOne(12);
		Assert.assertEquals(new Integer(25), girl.getAge());
	}
}
