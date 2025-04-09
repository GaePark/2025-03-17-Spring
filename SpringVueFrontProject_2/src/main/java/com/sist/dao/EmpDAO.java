package com.sist.dao;
import com.sist.vo.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	public List<DeptVO> deptListData()
	{
		return mapper.deptListData();
	}
}
