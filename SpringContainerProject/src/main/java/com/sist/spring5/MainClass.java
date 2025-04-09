package com.sist.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
/*
 * ���������� XML�� �о
 * 1)�޸� �Ҵ�
 * 2) Map�� ����
 * 3) ���
 * 4) ��ü �Ҹ�
 * 
 * �����̳� => ��ü�� ���� �ֱ� ����
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app= new ClassPathXmlApplicationContext("application.xml");
		Sawon sa=(Sawon) app.getBean("sawon");
		sa.display();
		Member member= (Member)app.getBean("member");
		member.display();
		//����� (����) Ŭ���� ã�� => DL 
		Student std=(Student) app.getBean("std");
		std.display();
	}

}
