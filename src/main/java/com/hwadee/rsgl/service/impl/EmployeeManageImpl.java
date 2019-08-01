package com.hwadee.rsgl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwadee.rsgl.dao.ChineseMapper;
import com.hwadee.rsgl.dao.CodingMapper;
import com.hwadee.rsgl.dao.EmployeeMapper;
import com.hwadee.rsgl.dao.EnglishMapper;
import com.hwadee.rsgl.dao.MajorChageMapper;
import com.hwadee.rsgl.dao.MathMapper;
import com.hwadee.rsgl.dao.PeMapper;
import com.hwadee.rsgl.dao.PositionChageMapper;
import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.model.English;
import com.hwadee.rsgl.model.MajorChage;
import com.hwadee.rsgl.service.EmployeeManage;
import com.hwadee.rsgl.model.Math;
import com.hwadee.rsgl.model.Pe;
import com.hwadee.rsgl.model.PositionChage;
import com.hwadee.rsgl.model.Chinese;
import com.hwadee.rsgl.model.Coding;
import com.hwadee.rsgl.model.English;

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
	@Autowired
	private PositionChageMapper positionChageMapper;
	@Autowired
	private MajorChageMapper majorChageMapper;
	
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
		}else if(employee.getMajor().equals("chinese")) {
			Chinese chinese=new Chinese();
			chinese.setEmployeeId(employee.getEmployeeId());
			chinese.setEmployeeName(employee.getEmployeeName());
			chineseMapper.insert(chinese);
		}else if(employee.getMajor().equals("english")){
			English english=new English();
			english.setEmployeeId(employee.getEmployeeId());
			english.setEmployeeName(employee.getEmployeeName());
			englishMapper.insert(english);
		}else if(employee.getMajor().equals("coding")) {
			Coding coding=new Coding();
			coding.setEmployeeId(employee.getEmployeeId());
			coding.setEmployeeName(employee.getEmployeeName());
			codingMapper.insert(coding);
		}else if(employee.getMajor().equals("pe")) {
			Pe pe=new Pe();
			pe.setEmployeeId(employee.getEmployeeId());
			pe.setEmployeeName(employee.getEmployeeName());
			peMapper.insert(pe);
		}else {
			return;
		}
	}
	
	public void passwordChange(Employee employee) {
		employeeMapper.updateByPrimaryKey(employee);
	}
	
	public void positionChange(PositionChage positionChage) {
		positionChageMapper.insert(positionChage);
	}
	
	public void majorChange(MajorChage majorChage) {
		majorChageMapper.insert(majorChage);
	}
	
	public List<MajorChage> positionChangeCheck() {
		return majorChageMapper.selectAll();
	}
}
