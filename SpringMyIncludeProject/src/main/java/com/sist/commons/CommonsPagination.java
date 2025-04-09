package com.sist.commons;

import java.util.*;


public class CommonsPagination {
	public static Map pageConfig(String page,int rowSize)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage*rowSize)-(rowSize-1);
		int end=(curpage*rowSize);
		Map map = new HashMap();
		map.put("curpage", curpage);
		map.put("start", start);
		map.put("end", end);
		return map;
	}
}
