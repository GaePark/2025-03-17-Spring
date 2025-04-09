package com.sist.temp;

import java.lang.reflect.Method;

class A
{
	public void aaa() {
		System.out.println("A:aaa() call...");
	}
	public void bbb() {
		System.out.println("B:bbb() call...");
	}
	public void ccc() {
		System.out.println("C:ccc() call...");
	}
}
public class MainClass {
	public static void main(String[] args) {
		try {
			Class clsName=Class.forName("com.sist.temp.A");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods = clsName.getDeclaredMethods();
			
			methods[0].invoke(obj, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
