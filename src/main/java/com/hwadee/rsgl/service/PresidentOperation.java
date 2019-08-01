package com.hwadee.rsgl.service;

import java.util.List;

import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.model.PositionChage;

public interface PresidentOperation{
	void calculateSalary();
	List<Employee> showAllEmployeeInfo();
	Employee selectOneEmployeeInfo(int employeeId);
	public List<PositionChage> positionChageAll();
	public PositionChage positionChangeCheck(int number, int judge);
}
