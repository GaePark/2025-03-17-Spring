package com.sist.service;
import com.sist.vo.*;
import java.util.*;
public interface FoodService {
	public List<FoodVO> foodListData(int start, int end);
	public int foodTotalPage();
}
