package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class MovieDAO {
	@Autowired
	private MovieMapper mapper;
	
	public void MovieInsert(MovieVO vo)
	{
		mapper.MovieInsert(vo);
	}
	
	public void movieDelete()
	{
		mapper.MovieDelete();
		
	}
	public List<MovieVO> movieListData()
	{
		return mapper.movieListData();
	}
}
