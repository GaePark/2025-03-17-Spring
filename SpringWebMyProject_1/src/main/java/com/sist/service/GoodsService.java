package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.GoodsVO;

public interface GoodsService {
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalData();
	public void hitIncrement(int no);
	GoodsVO goodsDetailData(int no);
}
