package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class EmpRestController {
	@Autowired 
	private EmpService service;
	@GetMapping(value = "emp/list_vue.do", produces = "application/json;charset=UTF-8")
	public List<EmpVO> emp_list_ok()
	{
		
		return service.empListData();
		
	}
	@GetMapping(value="emp/elist_vue.do",produces = "text/plain;charset=UTF-8")
	public String emp_elist_vue() throws Exception
	{
		List<EmpVO> elist=service.empListData();
		List<DeptVO> dlist=service.deptListData();
		
		ObjectMapper mapper = new ObjectMapper();
		Map map= new HashMap();
		map.put("emp", elist);
		map.put("dept", dlist);
		String json = mapper.writeValueAsString(map);
		return json;
	}
}
