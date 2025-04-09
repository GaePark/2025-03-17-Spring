package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
import java.util.*;
public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,GOODS_DELIVERY,goods_poster,hit,likecount,replycount,num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,GOODS_DELIVERY,goods_poster,hit,likecount,replycount,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,GOODS_DELIVERY,goods_poster,hit,likecount,replycount "
			+ "FROM goods_all ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalData();
	@Update("UPDATE goods_all SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	@Select("SELECT * FROM goods_all "
			+ "WHERE goods_no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
}
