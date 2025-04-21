package com.sist.vo;

import lombok.Data;

/*
 NO	NUMBER
CNO	NUMBER
TITLE	VARCHAR2(500 BYTE)
POSTER	VARCHAR2(260 BYTE)
ADDRESS	VARCHAR2(500 BYTE)
PHONE	VARCHAR2(100 BYTE)
INFO	VARCHAR2(3000 BYTE)
 */
@Data
public class BusanInfoVO {
	private int no,cno;
	private String title,poster,address,phone,info;
}
