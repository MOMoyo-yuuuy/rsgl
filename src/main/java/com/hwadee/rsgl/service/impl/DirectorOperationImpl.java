package com.hwadee.rsgl.service.impl;

import com.hwadee.rsgl.dao.ChineseMapper;
import com.hwadee.rsgl.dao.CodingMapper;
import com.hwadee.rsgl.dao.EmployeeMapper;
import com.hwadee.rsgl.dao.EnglishMapper;
import com.hwadee.rsgl.dao.MajorChageMapper;
import com.hwadee.rsgl.dao.MathMapper;
import com.hwadee.rsgl.dao.PeMapper;
import com.hwadee.rsgl.model.Employee;
import com.hwadee.rsgl.model.English;
import com.hwadee.rsgl.model.MajorChage;
import com.hwadee.rsgl.service.DirectorOperation;
import com.hwadee.rsgl.model.Chinese;
import com.hwadee.rsgl.model.Coding;
import com.hwadee.rsgl.model.Math;
import com.hwadee.rsgl.model.Pe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorOperationImpl implements DirectorOperation {
	@Autowired
	private MajorChageMapper majorChageMapper;
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

	public MajorChage majorChangeCheck(int number, int judge) {

		MajorChage majorChage = new MajorChage();
		majorChage = majorChageMapper.selectByPrimaryKey(number);
		majorChageMapper.deleteByPrimaryKey(number);
		if (judge == 1) {
			Employee employee = new Employee();
			employee = employeeMapper.selectByPrimaryKey(majorChage.getEmployeeId());
			employee.setMajor(majorChage.getNewMajor());
			employeeMapper.updateByPrimaryKey(employee);
			String oldmajor = majorChage.getOldMajor();
			String newmajor = majorChage.getNewMajor();
			if (oldmajor != null) {
				if (oldmajor.equals("chinese")) {
					chineseMapper.deleteByPrimaryKey(employee.getEmployeeId());
				} else if (oldmajor.equals("coding")) {
					codingMapper.deleteByPrimaryKey(employee.getEmployeeId());
				} else if (oldmajor.equals("english")) {
					englishMapper.deleteByPrimaryKey(employee.getEmployeeId());
				} else if (oldmajor.equals("math")) {
					mathMapper.deleteByPrimaryKey(employee.getEmployeeId());
				} else if (oldmajor.equals("pe")) {
					peMapper.deleteByPrimaryKey(employee.getEmployeeId());
				}
			}
			List<Employee> employees = employeeMapper.selectAll();
			int[] check = new int[20];
			employees.forEach(employee1 -> {
				Chinese chinese = chineseMapper.selectByPrimaryKey(employee1.getEmployeeId());
				Coding coding = codingMapper.selectByPrimaryKey(employee1.getEmployeeId());
				English english = englishMapper.selectByPrimaryKey(employee1.getEmployeeId());
				Math math = mathMapper.selectByPrimaryKey(employee1.getEmployeeId());
				Pe pe = peMapper.selectByPrimaryKey(employee1.getEmployeeId());
				if (chinese != null) {
					if (chinese.getClass1() == 1) {
						check[0] = 1;
					}
					if (chinese.getClass2() == 1) {
						check[5] = 1;
					}
					if (chinese.getClass3() == 1) {
						check[10] = 1;
					}
					if (chinese.getClass4() == 1) {
						check[15] = 1;
					}
				}
				if (math != null) {
					if (math.getClass1() == 1) {
						check[1] = 1;
					}
					if (math.getClass2() == 1) {
						check[6] = 1;
					}
					if (math.getClass3() == 1) {
						check[11] = 1;
					}
					if (math.getClass4() == 1) {
						check[16] = 1;
					}
				}
				if (english != null) {

					if (english.getClass1() == 1) {
						check[2] = 1;
					}
					if (english.getClass2() == 1) {
						check[7] = 1;
					}
					if (english.getClass3() == 1) {
						check[12] = 1;
					}
					if (english.getClass4() == 1) {
						check[17] = 1;
					}
				}
				if (pe != null) {
					if (pe.getClass1() == 1) {
						check[3] = 1;
					}
					if (pe.getClass2() == 1) {
						check[8] = 1;
					}
					if (pe.getClass3() == 1) {
						check[13] = 1;
					}
					if (pe.getClass4() == 1) {
						check[18] = 1;
					}
				}
				if (coding != null) {
					if (coding.getClass1() == 1) {
						check[4] = 1;
					}
					if (coding.getClass2() == 1) {
						check[9] = 1;
					}
					if (coding.getClass3() == 1) {
						check[14] = 1;
					}
					if (coding.getClass4() == 1) {
						check[19] = 1;
					}
				}
			});
			Chinese chinese = new Chinese();
			if (newmajor.equals("chinese")) {
				if (check[0] == 0) {
					chinese.setClass1(1);
					chinese.setClass2(0);
					chinese.setClass3(0);
					chinese.setClass4(0);
					chinese.setEmployeeId(employee.getEmployeeId());
					chinese.setEmployeeName(employee.getEmployeeName());
					chineseMapper.insert(chinese);
					return majorChage;
				}
				if (check[5] == 0) {
					chinese.setClass1(0);
					chinese.setClass2(1);
					chinese.setClass3(0);
					chinese.setClass4(0);
					chinese.setEmployeeId(employee.getEmployeeId());
					chinese.setEmployeeName(employee.getEmployeeName());
					chineseMapper.insert(chinese);
					return majorChage;
				}
				if (check[10] == 0) {
					chinese.setClass1(0);
					chinese.setClass2(0);
					chinese.setClass3(1);
					chinese.setClass4(0);
					chinese.setEmployeeId(employee.getEmployeeId());
					chinese.setEmployeeName(employee.getEmployeeName());
					chineseMapper.insert(chinese);
					return majorChage;
				}
				if (check[15] == 0) {
					chinese.setClass1(0);
					chinese.setClass2(0);
					chinese.setClass3(0);
					chinese.setClass4(1);
					chinese.setEmployeeId(employee.getEmployeeId());
					chinese.setEmployeeName(employee.getEmployeeName());
					chineseMapper.insert(chinese);
					return majorChage;
				}
			}
			Math math = new Math();
			if (newmajor.equals("math")) {
				if (check[1] == 0) {
					math.setClass1(1);
					math.setClass2(0);
					math.setClass3(0);
					math.setClass4(0);
					math.setEmployeeId(employee.getEmployeeId());
					math.setEmployeeName(employee.getEmployeeName());
					mathMapper.insert(math);
					return majorChage;
				}
				if (check[6] == 0) {
					math.setClass1(0);
					math.setClass2(1);
					math.setClass3(0);
					math.setClass4(0);
					math.setEmployeeId(employee.getEmployeeId());
					math.setEmployeeName(employee.getEmployeeName());
					mathMapper.insert(math);
					return majorChage;
				}
				if (check[11] == 0) {
					math.setClass1(0);
					math.setClass2(0);
					math.setClass3(1);
					math.setClass4(0);
					math.setEmployeeId(employee.getEmployeeId());
					math.setEmployeeName(employee.getEmployeeName());
					mathMapper.insert(math);
					return majorChage;
				}
				if (check[16] == 0) {
					math.setClass1(0);
					math.setClass2(0);
					math.setClass3(0);
					math.setClass4(1);
					math.setEmployeeId(employee.getEmployeeId());
					math.setEmployeeName(employee.getEmployeeName());
					mathMapper.insert(math);
					return majorChage;
				}

			}
			English english = new English();
			if (newmajor.equals("english")) {
				if (check[2] == 0) {
					english.setClass1(1);
					english.setClass2(0);
					english.setClass3(0);
					english.setClass4(0);
					english.setEmployeeId(employee.getEmployeeId());
					english.setEmployeeName(employee.getEmployeeName());
					englishMapper.insert(english);
					return majorChage;

				}
				if (check[7] == 0) {
					english.setClass1(0);
					english.setClass2(1);
					english.setClass3(0);
					english.setClass4(0);
					english.setEmployeeId(employee.getEmployeeId());
					english.setEmployeeName(employee.getEmployeeName());
					englishMapper.insert(english);
					return majorChage;
				}
				if (check[12] == 0) {
					english.setClass1(0);
					english.setClass2(0);
					english.setClass3(1);
					english.setClass4(0);
					english.setEmployeeId(employee.getEmployeeId());
					english.setEmployeeName(employee.getEmployeeName());
					englishMapper.insert(english);
					return majorChage;
				}
				if (check[17] == 0) {
					english.setClass1(0);
					english.setClass2(0);
					english.setClass3(0);
					english.setClass4(1);
					english.setEmployeeId(employee.getEmployeeId());
					english.setEmployeeName(employee.getEmployeeName());
					englishMapper.insert(english);
					return majorChage;
				}
			}
			Pe pe = new Pe();
			if (newmajor.equals("pe")) {
				if (check[3] == 0) {
					pe.setClass1(1);
					pe.setClass2(0);
					pe.setClass3(0);
					pe.setClass4(0);
					pe.setEmployeeId(employee.getEmployeeId());
					pe.setEmployeeName(employee.getEmployeeName());
					peMapper.insert(pe);
					return majorChage;
				}
				if (check[8] == 0) {
					pe.setClass1(0);
					pe.setClass2(1);
					pe.setClass3(0);
					pe.setClass4(0);
					pe.setEmployeeId(employee.getEmployeeId());
					pe.setEmployeeName(employee.getEmployeeName());
					peMapper.insert(pe);
					return majorChage;
				}
				if (check[13] == 0) {
					pe.setClass1(0);
					pe.setClass2(0);
					pe.setClass3(1);
					pe.setClass4(0);
					pe.setEmployeeId(employee.getEmployeeId());
					pe.setEmployeeName(employee.getEmployeeName());
					peMapper.insert(pe);
					return majorChage;
				}
				if (check[18] == 0) {
					pe.setClass1(0);
					pe.setClass2(0);
					pe.setClass3(0);
					pe.setClass4(1);
					pe.setEmployeeId(employee.getEmployeeId());
					pe.setEmployeeName(employee.getEmployeeName());
					peMapper.insert(pe);
					return majorChage;
				}
			}
			Coding coding = new Coding();
			if (newmajor.equals("coding")) {
				if (check[4] == 0) {
					coding.setClass1(1);
					coding.setClass2(0);
					coding.setClass3(0);
					coding.setClass4(0);
					coding.setEmployeeId(employee.getEmployeeId());
					coding.setEmployeeName(employee.getEmployeeName());
					codingMapper.insert(coding);
					return majorChage;
				}
				if (check[9] == 0) {
					coding.setClass1(0);
					coding.setClass2(1);
					coding.setClass3(0);
					coding.setClass4(0);
					coding.setEmployeeId(employee.getEmployeeId());
					coding.setEmployeeName(employee.getEmployeeName());
					codingMapper.insert(coding);
					return majorChage;
				}
				if (check[14] == 0) {
					coding.setClass1(0);
					coding.setClass2(0);
					coding.setClass3(1);
					coding.setClass4(0);
					coding.setEmployeeId(employee.getEmployeeId());
					coding.setEmployeeName(employee.getEmployeeName());
					codingMapper.insert(coding);
					return majorChage;
				}
				if (check[19] == 0) {
					coding.setClass1(0);
					coding.setClass2(0);
					coding.setClass3(0);
					coding.setClass4(1);
					coding.setEmployeeId(employee.getEmployeeId());
					coding.setEmployeeName(employee.getEmployeeName());
					codingMapper.insert(coding);
					return majorChage;
				}
			}

		}
		return majorChage;

	}

	public List<MajorChage> majorChangeAll() {
		return majorChageMapper.selectAll();

	}

	public int[] vacancycheck() {
		List<Employee> employees = employeeMapper.selectAll();
		int[] check = new int[20];
		employees.forEach(employee -> {
			Chinese chinese = chineseMapper.selectByPrimaryKey(employee.getEmployeeId());
			Coding coding = codingMapper.selectByPrimaryKey(employee.getEmployeeId());
			English english = englishMapper.selectByPrimaryKey(employee.getEmployeeId());
			Math math = mathMapper.selectByPrimaryKey(employee.getEmployeeId());
			Pe pe = peMapper.selectByPrimaryKey(employee.getEmployeeId());
			if (chinese != null) {
				if (chinese.getClass1() == 1) {
					check[0] = 1;
				}
				if (chinese.getClass2() == 1) {
					check[5] = 1;
				}
				if (chinese.getClass3() == 1) {
					check[10] = 1;
				}
				if (chinese.getClass4() == 1) {
					check[15] = 1;
				}
			}
			if (math != null) {
				if (math.getClass1() == 1) {
					check[1] = 1;
				}
				if (math.getClass2() == 1) {
					check[6] = 1;
				}
				if (math.getClass3() == 1) {
					check[11] = 1;
				}
				if (math.getClass4() == 1) {
					check[16] = 1;
				}
			}
			if (english != null) {

				if (english.getClass1() == 1) {
					check[2] = 1;
				}
				if (english.getClass2() == 1) {
					check[7] = 1;
				}
				if (english.getClass3() == 1) {
					check[12] = 1;
				}
				if (english.getClass4() == 1) {
					check[17] = 1;
				}
			}
			if (pe != null) {
				if (pe.getClass1() == 1) {
					check[3] = 1;
				}
				if (pe.getClass2() == 1) {
					check[8] = 1;
				}
				if (pe.getClass3() == 1) {
					check[13] = 1;
				}
				if (pe.getClass4() == 1) {
					check[18] = 1;
				}
			}
			if (coding != null) {
				if (coding.getClass1() == 1) {
					check[4] = 1;
				}
				if (coding.getClass2() == 1) {
					check[9] = 1;
				}
				if (coding.getClass3() == 1) {
					check[14] = 1;
				}
				if (coding.getClass4() == 1) {
					check[19] = 1;
				}
			}
		});
		return check;
	}

}
