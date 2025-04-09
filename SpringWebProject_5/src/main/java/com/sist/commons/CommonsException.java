package com.sist.commons;

import java.sql.SQLException;
import java.io.*;

import org.springframework.web.bind.annotation.ControllerAdvice;
//공통 예외 처리
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex)
	{
		System.out.println("========데이터베이스 오류==========");
		ex.printStackTrace();
	}
	@ExceptionHandler(IOException.class)
	public void IOException(IOException ex)
	{
		System.out.println("======== 입출력 오류==========");
		ex.printStackTrace();
	}
	@ExceptionHandler(Exception.class)
	public void Exception(Exception ex)
	{
		System.out.println("======== 기타 오류==========");
		ex.printStackTrace();
	}
}
