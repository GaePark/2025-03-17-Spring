package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 스프링 프레임워크
 * -------------
 * 1. Container : 클래스를 모아서 관리
 * 	  BeanFactory : core (객체 생성 / DI)
 * 		ㅣ
 *    ApplicationContext : default core (객체 생성 / DI/AOP)
 *      ㅣ
 *   WebApplicationContext : core (객체 생성 / DI/ AOP / MVD)
 *   => GenericApplicationContext=> 닫기 (객체 소멸)
 *   => AnnotataionConfigApplicationContext
 *   	=> 5버전에서 주로 사용
 *   	   ------ 보안 주력
 *   		등록 : XML => 순수자바 설정이 가능
 *    기능
 *     = 객체 생명주기 관리 (생성 ~ 소멸) => 모든 클래스 (VO => 데이터형)
 *     = 객체 찾기 (getBean())
 *     = DL (객체 찾기) / DI (변수의 초기화)
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
