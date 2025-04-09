<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>	

		<h3>답변하기</h3>
	   <form method="post" action="reply_ok.do"
   		>
		<table class="table">
			<tr>
				<th width=15%>이름</th>
				<td width=85%>
					<input type="text" name="name" size=20 required
					class="input-sm"
					/>
					<input type="hidden" name="pno" value="${no }">
				</td>
			</tr>
			<tr>
				<th width=15%>제목</th>
				<td width=85%>
					<input type="text" name="subject" size=50 required class="input-sm"/>
				</td>
			</tr>
			<tr>
				<th width=15%>내용</th>
				<td width=85%>
					<textarea name="content" rows="5" cols="52" required></textarea>
				</td>
			</tr>
			<tr>
				<th width=15%>비밀번호</th>
				<td width=85%>
					<input type="password" name="pwd" size=10 class="input-sm" required/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type=submit class="btn-sm btn-danger" value="답변">
					<input type=button class="btn-sm btn-success" value="취소" onClick="javascript:history.back()">
				</td>
			</tr>
		</table>
		</form>
	
</body>
</html>