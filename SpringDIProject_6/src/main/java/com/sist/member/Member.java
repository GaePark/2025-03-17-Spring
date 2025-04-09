package com.sist.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.sawon.*;
@Component("mem")
//@Target(value={TYPE})
/*  //멤버변수 구분 => FIELD
 *  어노테이션 => 구분자
 *  TYPE => 클래스 구분
 *  class A
 *  {
 *  	B b;
 *      public A(){}
 *      public void setB(B b) {} => METHOD
 *                      ----- PARAMETER
 *  }
 */
public class Member {
	@Autowired
	/*
	 * CONSTRUCTOR, 
	 * METHOD, 
	 * PARAMETER, 
	 * FIELD, 
	 * ANNOTATION_TYPE
	 * 
	 */
	private Sawon sawon; // sawon의 객체를 찾아서 주소값을 대입
	public void display()
	{
		System.out.println("사번:" + sawon.getSabun());
		System.out.println("이름" + sawon.getName());
	}
}
