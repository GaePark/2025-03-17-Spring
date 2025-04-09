package com.sist.main;
import com.sist.sawon.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.member.*;
public class MainClass {
public static void main(String[] args) {
	ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
	Member m=(Member)app.getBean("mem");
	m.display();
	
}
}
