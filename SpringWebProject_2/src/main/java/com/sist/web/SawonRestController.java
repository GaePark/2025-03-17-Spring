package com.sist.web;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.vo.*;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SawonRestController {
	@RequestMapping(value = "sawon/list.do",produces = "text/plain;charset=UTF-8")
	public String sawon_list() throws JsonProcessingException
	{
		List<SawonVO> list= new ArrayList<SawonVO>();
		SawonVO vo = new SawonVO();
		vo.setSabun(1);
		vo.setName("홍길동");
		vo.setDept("개발부");
		vo.setLoc("서울");
		vo.setJob("사원");
		vo.setPay(3000);
		list.add(vo);
		ObjectMapper mapper = new ObjectMapper();
		String s=mapper.writeValueAsString(list);
		
		return s;
		
	}
}
