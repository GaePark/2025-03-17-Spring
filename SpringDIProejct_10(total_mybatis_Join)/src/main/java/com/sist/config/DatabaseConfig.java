package com.sist.config;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
/*
 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
	/>
	<!-- MYBatis¿¬µ¿ : SqlSessionCatory -->
	<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
	/>
	<mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
 */
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sist.mapper" )
public class DatabaseConfig {

	@Bean("ds")
	public DataSource datasource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.apache.commons.dbcp.BasicDataSource");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
	return ds;
	}
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Throwable
	{
		SqlSessionFactoryBean ssf= new SqlSessionFactoryBean();
		ssf.setDataSource(datasource());
		return ssf.getObject();
	}
}
