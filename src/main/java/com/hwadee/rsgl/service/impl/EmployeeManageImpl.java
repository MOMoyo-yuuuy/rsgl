package com.hwadee.rsgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwadee.rsgl.dao.ChineseMapper;
import com.hwadee.rsgl.dao.CodingMapper;
import com.hwadee.rsgl.dao.EmployeeMapper;
import com.hwadee.rsgl.dao.EnglishMapper;
import com.hwadee.rsgl.dao.MathMapper;
import com.hwadee.rsgl.dao.PeMapper;
import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.service.EmployeeManage;
import com.hwadee.rsgl.model.Math;

@Service
public class EmployeeManageImpl implements EmployeeManage {
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private ChineseMapper chineseMapper;
	@Autowired
	private CodingMapper codingMapper;
	@Autowired
	private EnglishMapper englishMapper;
	@Autowired
	private MathMapper mathMapper;
	@Autowired
	private PeMapper peMapper;

	public void register(Employee employee) {
		employeeMapper.insert(employee);
	}

	public Employee login(int employeeId, String password){
		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
		if (null == password || !employee.getPassword().equals(password)) {
			throw new RuntimeException("账号或密码错误");
		}else {
			return employee;
		}
	}
	public Employee infoCheck(int employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}
	
	public void infoChange(Employee employee) {
		employeeMapper.updateByPrimaryKey(employee);
	}
	
	public void majorSet(Employee employee) {
		if(employee.getMajor().equals("math")) {
			Math math=new Math();
			math.setEmployeeId(employee.getEmployeeId());
			math.setEmployeeName(employee.getEmployeeName());
			mathMapper.insert(math);
		}
	}
	
}
