package com.sist.service;

import java.util.*;
import com.sist.vo.*;

public interface SeoulService {
	public List<SeoulVO> seoulListData(Map map);
	public int seoulTotalPage(Map map);
	public SeoulVO seoulDetailData(Map map);
}
