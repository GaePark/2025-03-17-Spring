package com.sist.auto;

import org.springframework.stereotype.Component;

@Component
public class MySQL implements DAO {

	@Override
	public void connection() {
		System.out.println("MySQL ����");
		
	}

	@Override
	public void colose() {
		System.out.println("MySQL ����");		
	}

}
