<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0 auto;
	width: 700px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>삭제하기</h3>
			<form method="post" action="delete_ok.do"></form>
			<table class="table">
				<tr>
					<td width="30$">비밀번호</td>
					<td width="70%">
						<input type="password" name="pwd" size=20 class="input-sm" required>
						<input type="hidden" name=no value="${no }">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="submit" value="삭제" " class="btn-sm btn-danger">
						<input type="button" value="취소" onclick="javascript:history.back()" class="btn-sm btn-primary"> 
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>