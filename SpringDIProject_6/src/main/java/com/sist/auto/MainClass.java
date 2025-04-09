package com.sist.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 * POJO방식을 주로 사용
 * ---- 일반자바 => 인터페이스 / 상속이 없는 독립된 클래
 */
@Component
public class MainClass {
	
	@Autowired
	@Qualifier(value="mySQL")
	private DAO dao;
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		MainClass mc=(MainClass) app.getBean("mainClass");
		mc.dao.connection();
	}
	
}
