package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
	@Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			+ "FROM emp")
	public List<EmpVO> empListDat();

	@Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			+ "FROM emp "
			+ "WHERE empno=#{empno}")
	public EmpVO empdetailData(int empno);
	@Results({
		@Result(property="dvo.dname",column="dname"),
		@Result(property="dvo.loc",column="loc")
	})
	@Select("SELECT empno,ename,job,sal,dname,loc "
			+ "FROM emp,dept "
			+ "WHERE emp.deptno=dept.deptno")
	public List<EmpVO> empJoinData();
}
