package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import java.util.*;
import com.sist.mapper.EmpMapper;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	
	public List<EmpVO> empListData()
	{
	return mapper.empListData();	
	}
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);
	}
}
