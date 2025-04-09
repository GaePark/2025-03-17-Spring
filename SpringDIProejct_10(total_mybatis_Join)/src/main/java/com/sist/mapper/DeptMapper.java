package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface DeptMapper {
	@Select("SELECT deptno,dname,loc FROM dept")
	public List<DeptVO> deptListData();
}
