package com.learning.sprinbootmockito.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.learning.sprinbootmockito.api.model.EmployeeModel;
import com.learning.sprinbootmockito.api.model.ResponseModel;
import com.learning.sprinbootmockito.api.service.EmployeeService;

@RestController
@RequestMapping("/EmployeeService")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@PostMapping("/addEmployee")
	public ResponseModel addEmployee(@RequestBody EmployeeModel employee) {
		
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/getEmployee")
	public ResponseModel getAllEmployee() {

	return employeeService.getAllEmployee();

	}

}
