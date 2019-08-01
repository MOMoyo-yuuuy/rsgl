package com.hwadee.rsgl.controller;

import java.util.Date;
import java.util.List;

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
import com.hwadee.rsgl.service.DirectorOperation;
import com.hwadee.rsgl.service.EmployeeManage;
import com.hwadee.rsgl.service.PresidentOperation;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeManage employeeManage;
	@Autowired
	private DirectorOperation directorOperation;
	@Autowired
	private PresidentOperation presidentOpreation;
	@Autowired
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Enter() {
		return "rsgl/login";
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
	
	
	@RequestMapping(value="/director",method=RequestMethod.GET)
	public String directorlogin(HttpSession session) {
		Employee employee=(Employee)session.getAttribute("employee");
		if(employee.getPosition().equals("director")) {
			return "redirect:/directorcheck";
		}else {
			return "rsgl/defeated";
		}
	}
	
	@RequestMapping(value="/directorcheck",method=RequestMethod.GET)
	public String directorcheck(Model model) {
		
		List<MajorChage> majorChages=directorOperation.majorChangeAll();
		model.addAttribute("majorChages",majorChages);
		return "rsgl/majorChageAllInfo";
	}
	
	@RequestMapping(value="/directorcheck",method=RequestMethod.DELETE)
	public String directorcheck(int number,int judge) {
		directorOperation.majorChangeCheck(number, judge);
		return "redirect:/directorcheck";
	}
	
	@RequestMapping(value="/president",method=RequestMethod.GET)
	public String presidentlogin(HttpSession session) {
		Employee employee=(Employee)session.getAttribute("employee");
		if(employee.getPosition().equals("president")) {
			return "redirect:/presidentinfo";
		}else {
			return "regl/defeated";
		}
	}
	
	@RequestMapping(value="/presidentinfo",method=RequestMethod.GET)
	public String presidentE(){
		return "rsgl/presidentpanel";
	}
	
	@RequestMapping(value="/showallemployeeinfo",method=RequestMethod.GET)
	public String showallemployeeinfo(Model model) {
		presidentOpreation.calculateSalary();
		List<Employee> employees=presidentOpreation.showAllEmployeeInfo();
		model.addAttribute("employees", employees);
		return "rsgl/presidentshowallinfo";
	}
	
	@RequestMapping(value="/showoneemployeeinfo",method=RequestMethod.GET)
	public String showOneEmployeeInfo(int employeeId,Model model) {
		Employee employee=presidentOpreation.selectOneEmployeeInfo(employeeId);
		model.addAttribute("employee",employee);
		return "rsgl/presidentshowoneinfo";
	}
	
	@RequestMapping(value="/positionchangecheck",method=RequestMethod.GET)
	public String positionChangeCheck(Model model) {
		List<PositionChage> positionChages=presidentOpreation.positionChageAll();
		model.addAttribute("positionChages",positionChages);
		return "rsgl/presidentchangecheck";
	}
	
	@RequestMapping(value="/positionchangecheck",method=RequestMethod.DELETE)
	public String positionChangeCheck(int number,int judge) {
		presidentOpreation.positionChangeCheck(number, judge);
		return "redirect:/positionchangecheck";
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
		return "rsgl/login";
		
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
