package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
@Select("SELECT fno,name,poster,rownum "
		+ "FROM FOOD_MENUPAN "
		+ "WHERE rownum<=12")
public List<FoodVO> foodListData();
}
