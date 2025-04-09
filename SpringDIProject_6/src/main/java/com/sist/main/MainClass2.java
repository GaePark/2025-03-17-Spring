package com.sist.main;
import com.sist.member.*;
import com.sist.sawon.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");
		Member mem=(Member)app.getBean("mem");
				mem.display();
	}

}
