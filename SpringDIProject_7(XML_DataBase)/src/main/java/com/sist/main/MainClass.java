package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao = (EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println("¿Ã∏ß:"+vo.getEname()+" "+vo.getJob()+" "+vo.getDbday()+" "+vo.getSal());
		}
		
	}

}
