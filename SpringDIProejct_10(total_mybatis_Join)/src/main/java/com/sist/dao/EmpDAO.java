package com.sist.dao;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpVO> empListDat()
	{
		return mapper.empJoinData();
	}
	public EmpVO empdetailData(int empno)
	{
		return mapper.empdetailData(empno);
	}
	public List<EmpVO> empJoinData()
	{
		return mapper.empJoinData();
	}
	
}
