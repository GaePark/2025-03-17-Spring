package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {
	@GetMapping("emp/list.do")
	public String emp_list() {
		
		return "emp/list";
	}
}
