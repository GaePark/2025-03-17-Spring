package com.sist.vo;

import lombok.Data;
//WEB : 1. 요청값 받기 / 2. 처리 / 3. 결과값 전송
@Data
public class SawonVO {
	private int sabun;
	private String name,dept,job,loc;
	private int pay;
}
