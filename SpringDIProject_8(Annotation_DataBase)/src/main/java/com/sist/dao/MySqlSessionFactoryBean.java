package com.sist.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		super.setDataSource(dataSource);
	}
}
