package com.hwadee.rsgl.service;

import java.util.List;

import com.hwadee.rsgl.model.MajorChage;

public interface DirectorOperation {
	MajorChage majorChangeCheck(int number,int judge);
	List<MajorChage> majorChangeAll();
}
