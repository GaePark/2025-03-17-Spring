package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.dao.*;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Service
public class EmpDeptServiceImpl implements EmpDeptService {
	@Autowired
	private EmpDAO eDao;
	@Autowired
	private DeptDAO dDao;
	@Override
	public List<DeptVO> deptListData() {
		// TODO Auto-generated method stub
		return dDao.deptListData();
	}

	@Override
	public List<EmpVO> empListDat() {
		// TODO Auto-generated method stub
		return eDao.empListDat();
	}

	@Override
	public EmpVO empdetailData(int empno) {
		// TODO Auto-generated method stub
		return eDao.empdetailData(empno);
	}

	@Override
	public List<EmpVO> empJoinData() {
		// TODO Auto-generated method stub
		return eDao.empJoinData();
	}
	
}
