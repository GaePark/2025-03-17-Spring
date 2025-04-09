package com.sist.spring3;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
@Select("SELECT empno,ename,job,TO_CHR(hiretate,'YYYY-MM-DD') as dbday, sal. FROM emp")
public List<EmpVO> empAllData();
 }
