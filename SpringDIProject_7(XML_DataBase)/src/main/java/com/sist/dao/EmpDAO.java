package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
public class EmpDAO {
	private EmpMapper mapper;

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
}
