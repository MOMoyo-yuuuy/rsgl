package com.hwadee.rsgl.service;

import com.hwadee.rsgl.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import com.hwadee.rsgl.dao.EmployeeMapper;

public interface EmployeeManage {
	void register(Employee employee);
	Employee login(int employeeId,String password);
	Employee infoCheck(int employeeId);
	void infoChange(Employee employee);
	void majorSet(Employee employee);
}
