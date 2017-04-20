package com.wt.ControllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.wt.controller.GirlController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllertTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void girlTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
