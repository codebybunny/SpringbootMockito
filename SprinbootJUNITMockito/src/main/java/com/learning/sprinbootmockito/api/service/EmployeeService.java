package com.learning.sprinbootmockito.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.sprinbootmockito.api.dao.EmployeeDao;
import com.learning.sprinbootmockito.api.model.EmployeeModel;
import com.learning.sprinbootmockito.api.model.ResponseModel;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao; 
	
	public ResponseModel addEmployee(@RequestBody EmployeeModel employee) {
		employeeDao.save(employee);
		return new ResponseModel(employee.getId() + "inserted", Boolean.TRUE);
	}
	
	public ResponseModel getAllEmployee() {
		
		List<EmployeeModel> list = employeeDao.findAll();
		
		return new ResponseModel("record counts: " + list.size(),Boolean.TRUE);
		
		
	}
	
}
