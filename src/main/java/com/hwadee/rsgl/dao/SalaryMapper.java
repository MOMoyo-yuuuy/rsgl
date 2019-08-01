package com.hwadee.rsgl.dao;

import java.util.List;

import com.hwadee.rsgl.model.Salary;

public interface SalaryMapper {
	List<Salary> findSalary();
	void salaryTableChange(Salary salary);
}
