package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;

import java.util.*;
@Repository
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;
	
	public void musicInsert(MusicVO vo)
	{
		mapper.musicInsert(vo);
	}
	public void musicDelete()
	{
		mapper.musicDelete();
	}
	public MusicVO musicTop()
	{
		return mapper.musicTop();
	}
	public void allDelete(int empno)
	{
		mapper.allDelete(empno);
	}
}
