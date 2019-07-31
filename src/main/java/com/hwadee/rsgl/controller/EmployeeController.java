package com.hwadee.rsgl.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.model.MajorChage;
import com.hwadee.rsgl.model.PositionChage;
import com.hwadee.rsgl.service.EmployeeManage;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeManage employeeManage;
	@RequestMapping(value="/enter",method=RequestMethod.GET)
	public String Enter() {
		return "rsgl/main";
	}
	@RequestMapping(value="/registerE",method=RequestMethod.GET)
	public String RegE() {
		return "rsgl/register";
	}
	@RequestMapping(value="/positionchangeE",method=RequestMethod.GET)
	public String PosE() {
		return "rsgl/positionchange";
	}
	@RequestMapping(value="/majorchangeE",method=RequestMethod.GET)
	public String MajE() {
		return "rsgl/majorchange";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(int employeeId, String password,HttpSession session) {
		Employee employee=employeeManage.login(employeeId, password);
		session.setAttribute("employee", employee);
		return "rsgl/personinfo";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(Employee employee) {
		Date date=new Date();
		employee.setEntryTime(date);
		employeeManage.register(employee);
		return "rsgl/main";
		
	}
	
	@RequestMapping(value="/infocheck",method=RequestMethod.GET)
	public String infocheck(HttpSession session,Model model) {
		Employee employee=(Employee)session.getAttribute("employee");
		Employee employee2=employeeManage.infoCheck(employee.getEmployeeId());
		model.addAttribute("employee2",employee2);
		return "rsgl/personinfocheck";
	}
	
	@RequestMapping(value="/infoupdate",method=RequestMethod.POST)
	public String infoupdate(String password,HttpSession session,Model model) {
		Employee employee=(Employee)session.getAttribute("employee");
		employee.setPassword(password);
		employeeManage.infoChange(employee);
		session.setAttribute("employee",employee);
		model.addAttribute("employee",employee);
		return "redirect:/infocheck";
	}
	
	@RequestMapping(value="/positionchange",method=RequestMethod.POST)
	public String positionchange(String position,HttpSession session) {
		Employee employee=(Employee)session.getAttribute("employee");
		PositionChage positionChage=new PositionChage();
		positionChage.setEmployeeName(employee.getEmployeeName());
		positionChage.setEmployeeId(employee.getEmployeeId());
		positionChage.setNewMajor(position);
		positionChage.setOldMajor(employee.getPosition());
		employeeManage.positionChange(positionChage);
		return "redirect:/infocheck";
	}
	
	@RequestMapping(value="/majorchange",method=RequestMethod.POST)
	public String majorchange(String major,HttpSession session) {
		Employee employee=(Employee)session.getAttribute("employee");
		MajorChage majorChage=new MajorChage();
		majorChage.setEmployeeId(employee.getEmployeeId());
		majorChage.setEmployeeName(employee.getEmployeeName());
		majorChage.setOldMajor(employee.getMajor());
		majorChage.setNewMajor(major);
		employeeManage.majorChange(majorChage);
		return "redirect:/infocheck";
	}
}
