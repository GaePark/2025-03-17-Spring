package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO gdao;

	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return gdao.goodsListData(map);
	}

	@Override
	public int goodsTotalData() {
		// TODO Auto-generated method stub
		return gdao.goodsTotalData();
	}



	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gdao.goodsDetailData(no);
	}

	@Override
	public void hitIncrement(int no) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
