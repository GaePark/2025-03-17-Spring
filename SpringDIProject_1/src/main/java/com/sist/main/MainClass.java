package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ������ �����ӿ�ũ
 * -------------
 * 1. Container : Ŭ������ ��Ƽ� ����
 * 	  BeanFactory : core (��ü ���� / DI)
 * 		��
 *    ApplicationContext : default core (��ü ���� / DI/AOP)
 *      ��
 *   WebApplicationContext : core (��ü ���� / DI/ AOP / MVD)
 *   => GenericApplicationContext=> �ݱ� (��ü �Ҹ�)
 *   => AnnotataionConfigApplicationContext
 *   	=> 5�������� �ַ� ���
 *   	   ------ ���� �ַ�
 *   		��� : XML => �����ڹ� ������ ����
 *    ���
 *     = ��ü �����ֱ� ���� (���� ~ �Ҹ�) => ��� Ŭ���� (VO => ��������)
 *     = ��ü ã�� (getBean())
 *     = DL (��ü ã��) / DI (������ �ʱ�ȭ)
 *                       1. setter
 *                       2.contstructor
 *                       3. methdos
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext app= new ClassPathXmlApplicationContext("app1.xml");
			Sawon sa = (Sawon) app.getBean("pay");
			sa.print();
	}

}
