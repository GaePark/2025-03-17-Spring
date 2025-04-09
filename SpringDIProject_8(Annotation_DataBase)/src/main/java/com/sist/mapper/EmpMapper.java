package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {
@Select("SELECT empno,ename,job,hiredate,sal "
		+ "FROM emp")
public List<EmpVO> empListData();

@Select("SELECT empno,ename,job,hiredate,sal "
		+ "FROM emp "
		+ "WHERE empno=#{empno}")
public EmpVO empDetailData(int empno);
//                 id         parameterType
// resultType  

//@Insert @Update @Delete
}
