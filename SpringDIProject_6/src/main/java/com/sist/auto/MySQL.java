package com.sist.auto;

import org.springframework.stereotype.Component;

@Component
public class MySQL implements DAO {

	@Override
	public void connection() {
		System.out.println("MySQL 연결");
		
	}

	@Override
	public void colose() {
		System.out.println("MySQL 해제");		
	}

}
