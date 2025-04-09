package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDAO dao;
	@Override
	public List<EmpVO> empListData() {
		// TODO Auto-generated method stub
		return dao.empListData();
	}
	@Override
	public List<DeptVO> deptListData() {
		// TODO Auto-generated method stub
		return dao.deptListData();
	}

}
