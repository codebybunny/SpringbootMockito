package com.learning.sprinbootmockito.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.sprinbootmockito.api.model.EmployeeModel;
import com.learning.sprinbootmockito.api.model.ResponseModel;

@SpringBootTest
class SprinbootJunitMockitoApplicationTests {
	
	
	public MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}
	@Test
	public void addEmployeeTest() throws Exception {
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setName("Rashmi Kumari");
		employeeModel.setDept("IT");
		
		String jsonRequest = objectMapper.writeValueAsString(employeeModel);
		MvcResult mvcResult = mockMvc.perform(post("/EmployeeService/addEmployee").content(jsonRequest).
				contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		
		String resultContent = mvcResult.getResponse().getContentAsString();
		
		ResponseModel responseModel = objectMapper.readValue(resultContent, ResponseModel.class);
		
		Assertions.assertTrue(responseModel.isStatus() == Boolean.TRUE);
	}
	
	
	/*
	 * @Test void contextLoads() { }
	 */
}
