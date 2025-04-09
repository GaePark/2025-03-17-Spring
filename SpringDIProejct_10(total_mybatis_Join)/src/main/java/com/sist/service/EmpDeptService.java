package com.sist.service;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
public interface EmpDeptService {
	public List<DeptVO> deptListData();
	public List<EmpVO> empListDat();
	public EmpVO empdetailData(int empno);
	public List<EmpVO> empJoinData();
}
