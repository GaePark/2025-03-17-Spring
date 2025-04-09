package com.sist.vo;

import lombok.Data;

/*
NO	NUMBER
TITLE	VARCHAR2(200 BYTE)
POSTER	VARCHAR2(300 BYTE)
MSG	VARCHAR2(4000 BYTE)
ADDRESS	VARCHAR2(300 BYTE)
HIT	NUMBER
LIKECOUNT	NUMBER
REPLYCOUNT	NUMBER
 */
@Data
public class SeoulVO {
	private int no,hit,likecount,replycount;
	private String title,poster,msg,address;
}
