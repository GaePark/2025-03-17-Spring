package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * ���� ���� => ����
 * -------
 *                   Controller
 * ����� ��û(.do) ==DispatcherServlet
 *                      ��
 *                    Model ã�� (@RequestMapping) : HandlerMapping
 *                      ��
 *                     Model ó�� => �޼ҵ� ȣ��
 *                      ��
 *                     JSP ã�� : ViewResolver  => ��θ� / Ȯ����
 *                                p:prefix="/"
 *                                p:suffix=".jsp"
 *                      �� => request ����
 *                     JSP
 * 
 */
@Controller
public class BoardModel {
	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request, HttpServletResponse response)
	{
		String msg="Hello Spring MVC!!";
		request.setAttribute("msg", msg);
		return "board/list";
	}
}
