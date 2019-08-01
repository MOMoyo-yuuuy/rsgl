package com.hwadee.rsgl.service;

import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.model.MajorChage;
import com.hwadee.rsgl.model.PositionChage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hwadee.rsgl.dao.EmployeeMapper;

public interface EmployeeManage {
	void register(Employee employee);
	Employee login(int employeeId,String password);
	Employee infoCheck(int employeeId);
	void infoChange(Employee employee);
	void majorSet(Employee employee);
	void passwordChange(Employee employee);
	void positionChange(PositionChage positionChage);
	void majorChange(MajorChage majorChage);
	List<MajorChage> positionChangeCheck();
}
