package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyVO>  replyListData(int bno){
		return mapper.replyListData(bno);
	}
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	public void replyUpdate(ReplyVO vo)
	{
		mapper.replyUpdate(vo);
	}
	public void replyDelete(int no)
	{
		ReplyVO vo = mapper.replyInfoData(no);
		System.out.println("dao");
		mapper.replyDelete(vo);
	}
	@Transactional
	public void replyReplyInsert(int pno,ReplyVO vo)
	{
	ReplyVO pvo =mapper.replyParentInfoData(pno);	
	mapper.replyGroupStepIncrement(pvo);
	vo.setGroup_id(pvo.getGroup_id());
	vo.setGroup_step(pvo.getGroup_step()+1);
	vo.setGroup_tab(pvo.getGroup_tab()+1);
	mapper.replyReplyInsert(vo);
	}
}
