package com.learning.sprinbootmockito.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.sprinbootmockito.api.model.EmployeeModel;

public interface EmployeeDao extends JpaRepository<EmployeeModel, Integer> {
	
	

}
