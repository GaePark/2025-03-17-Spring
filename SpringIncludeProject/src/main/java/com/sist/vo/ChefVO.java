package com.sist.vo;

import lombok.Data;

/*
NO	NUMBER
CHEF	VARCHAR2(300 BYTE)
POSTER	VARCHAR2(260 BYTE)
MEM_CONT1	VARCHAR2(30 BYTE)
MEM_CONT3	VARCHAR2(30 BYTE)
MEM_CONT7	VARCHAR2(30 BYTE)
MEM_CONT2	VARCHAR2(30 BYTE)
 */
@Data
public class ChefVO {
	private int no;
	private String chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2;
}
