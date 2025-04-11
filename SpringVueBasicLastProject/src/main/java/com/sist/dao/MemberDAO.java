package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.*;
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public MemberVO memberGetInfoData(String id, String pwd)
	{
		MemberVO vo =new MemberVO();
		int count = mapper.memberIdCOunt(id);
		if(count==0)
		{
			vo.setMsg("NOID");
		}
		else {
			MemberVO dbvo=mapper.memberGetInfoData(id);
			if(pwd.equals(dbvo.getPwd()))
			{
				vo.setMsg("OK");
				vo.setId(dbvo.getId());
				vo.setName(dbvo.getName());
				vo.setSex(dbvo.getSex());
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		
			
		return vo;
	}
}
