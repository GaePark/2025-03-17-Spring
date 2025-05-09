package com.sist.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 자동 로그인
/*
 * 1. Controller 역할 , AOP 역할
 * 2. Task역할 => 스케쥴러
 * 3. Interceptor
 * 4. DAO / Service
 * ---------------------------
 * include => tiles
 * 보안 / betch / 통계
 *               ----파이썬 (Pandas,Numpy)
 *                    ㅣDjango
 * Front : Vue => 디렉티브
 *                v-for v-if v-else v-model
 *                => 라이브러리 : jacksion
 *             => FrontController : 요청 받아서 HandlerMapping
 *                                  응답    
 *                                        ㅣModel을 찾아서 메소드 호출
 *                                        ㅣ@GetMapping / @PostMapping
 *                                         ---------------------------
 *                                           ㅣ@RequestMapping
 * main.do === DispatcherServlet ==== HandlerMapping
 *                                    ㅣ=>preHandle
 *                                    메소드 호출
 *                                    ㅣrequest.setAttribute()
 *                                     return ""
 *                                    ㅣ=> postHandle
 *                                    ViewResolver
 *                                    ㅣrequest
 *                                    ㅣ=> afterCompletion
 *                                    JSP
 */
public class RecipeInterceptor extends HandlerInterceptorAdapter {
	//자동 로그인 / ID저장 Remember-me
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
