package com.sist.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.sawon.*;
@Component("mem")
//@Target(value={TYPE})
/*  //������� ���� => FIELD
 *  ������̼� => ������
 *  TYPE => Ŭ���� ����
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
	private Sawon sawon; // sawon�� ��ü�� ã�Ƽ� �ּҰ��� ����
	public void display()
	{
		System.out.println("���:" + sawon.getSabun());
		System.out.println("�̸�" + sawon.getName());
	}
}
