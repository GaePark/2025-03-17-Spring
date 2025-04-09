package com.sist.auto;

import org.springframework.stereotype.Component;

@Component
public class Oracle implements DAO {

	@Override
	public void connection() {
		System.out.println("Oracle 연결");
		
	}

	@Override
	public void colose() {
		System.out.println("Oracle 해제");		
	}
}
