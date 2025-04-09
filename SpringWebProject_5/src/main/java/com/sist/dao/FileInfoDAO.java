package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;
@Repository
public class FileInfoDAO {
	@Autowired
	private FileInfoMapper mapper;
	
	public void boardFileInsert(FileInfoVO vo)
	{
		mapper.boardFileInsert(vo);
	}
	public List<FileInfoVO> fileListData(int no)
	{
		return mapper.fileListData(no);
	}
	public void fileInfoDelete(int no)
	{
		mapper.fileInfoDelete(no);
	}
}
