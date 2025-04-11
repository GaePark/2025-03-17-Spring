package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;
public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM project_member "
			+ "WHERE id=#{id}")
	public int memberIdCOunt(String id);
	
	@Select("SELECT id,name,pwd,sex FROM project_member "
			+ "WHERE id=#{id}")
	public MemberVO memberGetInfoData(String id);
	
	
}
