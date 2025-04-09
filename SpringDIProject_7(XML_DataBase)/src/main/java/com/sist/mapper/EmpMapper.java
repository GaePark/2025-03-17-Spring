package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
	/*
	 *  <select id="empListData" resultType="EmpVO">
	 *  SELECT empno,ename,job,sal, TO_CHAR(hiredate,'YYYY-MM-DD') as dbday
	 *  FROM emp
	 *  </select>
	 *  @select("SELECT empno,ename,job,sal, TO_CHAR(hiredate,'YYYY-MM-DD') as dbday
	 *  FROM emp")
	 *  public List<EmpVO> empListData(); => 자동 구현
	 */
	@Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday"
			+ " FROM emp")
	public List<EmpVO> empListData();
}
