package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MusicMapper;
import com.sist.vo.MusicVO;
@Repository
public class musicDAO {
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
	public List<MusicVO> musicListData()
	{
		return mapper.musicListData();
	}
}
