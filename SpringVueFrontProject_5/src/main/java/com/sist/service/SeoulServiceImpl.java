package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class SeoulServiceImpl implements SeoulService {
	@Autowired
	private SeoulDAO dao;

	@Override
	public List<SeoulVO> seoulListData(Map map) {
		// TODO Auto-generated method stub
		return dao.seoulListData(map);
	}

	@Override
	public int seoulTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dao.seoulTotalPage(map);
	}

	@Override
	public SeoulVO seoulDetailData(Map map) {
		// TODO Auto-generated method stub
		return dao.seoulDetailData(map);
	}
	
	
}
