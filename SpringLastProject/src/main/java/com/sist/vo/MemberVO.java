package com.sist.vo;
import java.util.*;

import lombok.Data;
//spring security
//=> userid : username
//=> pwd,userpwd:password
//role=> ROLE_ADMIN / ROLE_USER / ROLE_MANAGER...
@Data
public class MemberVO {
	private int enable;// 활성화, 비활성화 계정
	private String userid,username,userpwd,sex,birthday,email,post,addr1,addr2,phone,content,msg,authority;
	private Date regdate,modifydata,lastlogin;
}
