package com.hwadee.rsgl.service.impl;

import com.hwadee.rsgl.dao.EmployeeMapper;
import com.hwadee.rsgl.dao.MajorChageMapper;
import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.model.MajorChage;
import com.hwadee.rsgl.service.DirectorOperation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DirectorOperationImpl implements DirectorOperation{
	@Autowired
	private MajorChageMapper majorChageMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	public MajorChage majorChangeCheck(int number,int judge) {
		
		MajorChage majorChage=new MajorChage();
		majorChage=majorChageMapper.selectByPrimaryKey(number);
		majorChageMapper.deleteByPrimaryKey(number);
		if(judge==1) {
			Employee employee=new Employee();
			employee=employeeMapper.selectByPrimaryKey(majorChage.getEmployeeId());
			employee.setMajor(majorChage.getNewMajor());
			employeeMapper.updateByPrimaryKey(employee);
		}
		return majorChage;
		
	}

	public List<MajorChage> majorChangeAll() {
		return majorChageMapper.selectAll();
		
	}
	
}
