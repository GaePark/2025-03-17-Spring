package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@RestController
public class BoardRestController {
@Autowired
private BoardDAO dao;//스프링에서 객체 관리 => 관리하는 객체 주소 주입

@PostMapping(value = "board/update_ok.do", produces = "text/html;charset=UTF-8")
public String board_update_ok(BoardVO vo)
{
	String result="";
	boolean bCheck=dao.boardUpdate(vo);
	if(bCheck==true)
	{
		result="<script>location.href=\"../board/detail.do?no="+vo.getNo()+"\"</script>";
	}
	else
	{
		result="<script>"
				+ "alert('비밀번호가 틀립니다.');"
				+ "window.history.back();"
				+ "</script>";
	}
	return result;
}
@PostMapping(value = "board/delete_ok.do",produces = "text/html;charset=UTF-8")
public String board_delete_ok(int no,String pwd)
{
	String result="";
	boolean bCheck=dao.boardDelete(no, pwd);
	if(bCheck==true)
	{
		result="<script>location.href=\"../board/list.do\"</script>";
	}
	else
	{
		result="<script>"
				+ "alert('비밀번호가 틀립니다.');"
				+ "window.history.back();"
				+ "</script>";
	}
	return result;
}
}
