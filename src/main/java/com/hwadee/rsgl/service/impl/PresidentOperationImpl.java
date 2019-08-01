package com.hwadee.rsgl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwadee.rsgl.dao.EmployeeMapper;
import com.hwadee.rsgl.dao.PositionChageMapper;
import com.hwadee.rsgl.dao.SalaryMapper;
import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.model.MajorChage;
import com.hwadee.rsgl.model.PositionChage;
import com.hwadee.rsgl.model.Salary;
import com.hwadee.rsgl.service.PresidentOperation;
import com.hwadee.rsgl.model.Employee;

@Service
public class PresidentOperationImpl implements PresidentOperation {
	@Autowired
	private SalaryMapper salaryMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private PositionChageMapper positionChageMapper;

	public void calculateSalary() {
		// TODO Auto-generated method stub
		List<Salary> salarys = salaryMapper.findSalary();
		Salary salary = salarys.get(0);
		List<Employee> employees = employeeMapper.selectAll();
		employees.forEach(employee -> {
			int salarySum = 0;
			if (employee.getPosition().equals("president")) {
				salarySum += salary.getMaster();
			} else if (employee.getPosition().equals("director")) {
				salarySum += salary.getManager();
			} else if (employee.getPosition().equals("teacher")) {
				salarySum += salary.getTeacher();
			}
			if (employee.getMajor().equals("chinese")) {
				salarySum += salary.getChinese();
			} else if (employee.getMajor().equals("coding")) {
				salarySum += salary.getCoding();
			} else if (employee.getMajor().equals("pe")) {
				salarySum += salary.getPe();
			} else if (employee.getMajor().equals("math")) {
				salarySum += salary.getMath();
			} else if (employee.getMajor().equals("english")) {
				salarySum += salary.getEnglish();
			}
			employee.setSalary(salarySum);
			employeeMapper.updateByPrimaryKey(employee);
		});
	}

	@Override
	public List<Employee> showAllEmployeeInfo() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeMapper.selectAll();
		return employees;
	}

	public Employee selectOneEmployeeInfo(int employeeId) {
		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
		return employee;
	}

	public List<PositionChage> positionChageAll() {
		return positionChageMapper.selectAll();
	}

	public PositionChage positionChangeCheck(int number, int judge) {

		PositionChage positionChage = positionChageMapper.selectByPrimaryKey(number);
		positionChageMapper.deleteByPrimaryKey(number);
		if (judge == 1) {
			Employee employee = new Employee();
			employee = employeeMapper.selectByPrimaryKey(positionChage.getEmployeeId());
			employee.setMajor(positionChage.getNewMajor());
			employeeMapper.updateByPrimaryKey(employee);
		}
		return positionChage;

	}
}
