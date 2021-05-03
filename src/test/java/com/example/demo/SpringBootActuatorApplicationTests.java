package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootActuatorApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testSampleController() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders
					.get("/sample/var1");
		
		MvcResult result = mockMvc.perform(builder).andReturn();
		
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertTrue(result.getResponse().getContentAsString().contains("var1"));
		
	}

}
