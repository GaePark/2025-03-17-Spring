package com.sist.main;

import org.apache.commons.dbcp.BasicDataSource;

public class MyBasicDataSource extends BasicDataSource {
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
	}
}
