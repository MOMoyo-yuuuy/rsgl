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
	@RequestMapping(value="/infoupdateE",method=RequestMethod.GET)
	public String infoupdateE() {
		return "rsgl/infoupdate";
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
	public String presidentpanel(Model model){
		List<PositionChage> positionChages=presidentOpreation.positionChageAll();
		model.addAttribute("positionChages",positionChages);
		presidentOpreation.calculateSalary();
		List<Employee> employees=presidentOpreation.showAllEmployeeInfo();
		model.addAttribute("employees", employees);
		return "rsgl/presidentpanel";
		
	}
	@RequestMapping(value="/presidentinfo",method=RequestMethod.PUT)
	public String presidentpasswordChange(HttpSession session,String newPassword) {
		Employee employee=(Employee)session.getAttribute("employee");
		employee.setPassword(newPassword);
		session.setAttribute("employee", employee);
		return "redirect:/presidentinfo";
	}
	
	@RequestMapping(value="/presidentinfo",method=RequestMethod.POST)
	public String showOneEmployeeInfo(int employeeId,Model model) {
		Employee employee=presidentOpreation.selectOneEmployeeInfo(employeeId);
		model.addAttribute("employee",employee);
		return "rsgl/presidentshowoneinfo";
	}
	
//	@RequestMapping(value="/showallemployeeinfo",method=RequestMethod.GET)
//	public String showallemployeeinfo(Model model) {
//		presidentOpreation.calculateSalary();
//		List<Employee> employees=presidentOpreation.showAllEmployeeInfo();
//		model.addAttribute("employees", employees);
//		return "rsgl/presidentshowallinfo";
//	}
	
//	@RequestMapping(value="/showoneemployeeinfo",method=RequestMethod.GET)
//	public String showOneEmployeeInfo(int employeeId,Model model) {
//		Employee employee=presidentOpreation.selectOneEmployeeInfo(employeeId);
//		model.addAttribute("employee",employee);
//		return "rsgl/presidentshowoneinfo";
//	}
	
//	@RequestMapping(value="/positionchangecheck",method=RequestMethod.GET)
//	public String positionChangeCheck(Model model) {
//		List<PositionChage> positionChages=presidentOpreation.positionChageAll();
//		model.addAttribute("positionChages",positionChages);
//		return "rsgl/presidentchangecheck";
//	}
	
	@RequestMapping(value="/positionchangecheck",method=RequestMethod.DELETE)
	public String positionChangeCheck(int number,int judge) {
		presidentOpreation.positionChangeCheck(number, judge);
		return "redirect:/positionchangecheck";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(int employeeId, String password,HttpSession session) {
		Employee employee=employeeManage.login(employeeId, password);
		session.setAttribute("employee", employee);
		if(employee.getPosition()!=null&&employee.getPosition().equals("president")) {
			return "redirect:/presidentinfo";
		}else if(employee.getPosition()!=null&&employee.getPosition().equals("director")) {
			return "redirect:/director";
		}else {
			return "redirect:/infocheck";
		}
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
		session.setAttribute("employee", employee2);
		return "rsgl/personinfo";
	}
	
	@RequestMapping(value="/infoupdate",method=RequestMethod.POST)
	public String infoupdate(Employee employeeG,HttpSession session,Model model) {
		Employee employee=(Employee)session.getAttribute("employee");
		employeeG.setEmployeeId(employee.getEmployeeId());
		employeeG.setEntryTime(employee.getEntryTime());
		employeeG.setSalary(employee.getSalary());
		employeeG.setMajor(employee.getMajor());
		employeeG.setPosition(employee.getPosition());
		employeeG.setPassword(employee.getPassword());
		employeeManage.infoChange(employeeG);
		session.setAttribute("employee",employeeG);
		model.addAttribute("employee",employeeG);
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
	
	@RequestMapping(value="/leave",method=RequestMethod.POST)
	public String leave(int employeeId) {
		employeeManage.leave(employeeId);
		return "redirect:/login";
	}
	
	@RequestMapping(value="/teacherpasswordchange",method=RequestMethod.POST)
	public String teacherpasswordchange(String newPassword,HttpSession session) {
		Employee employee=(Employee)session.getAttribute("employee");
		employee.setPassword(newPassword);
		employeeManage.passwordChange(employee);
		session.setAttribute("employee", employee);
		return "redirect:/infocheck";
		
	}
	
	@RequestMapping(value="/positionresult",method=RequestMethod.GET)
	public String positionresult(Model model,HttpSession session ) {
		Employee employee=(Employee)session.getAttribute("employee");
		model.addAttribute("employeeId",employee.getEmployeeId());
		model.addAttribute("result",employeeManage.positionResult(employee));
		return "rsgl/positionresult";
	}
	
	@RequestMapping(value="/majorresult",method=RequestMethod.GET)
	public String majorresult(Model model,HttpSession session) {
		Employee employee=(Employee)session.getAttribute("employee");
		model.addAttribute("employeeId",employee.getEmployeeId());
		model.addAttribute("result",employeeManage.majorResult(employee));
		return "rsgl/majorresult";
	}
}
