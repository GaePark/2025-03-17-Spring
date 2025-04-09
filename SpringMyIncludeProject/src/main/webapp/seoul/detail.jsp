<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	jdk => 오라클 (X) => 11~14
	=> openjdk
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<tr>
			<td colspan="2">
			${vo.poster }
			</td>
		</tr>
		<tr>
			<th class="text-center">업체명</th>
			<td class="text-center">${vo.title }</td>
		</tr>
		<tr>
			<th class="text-center">소개</th>
			<td class="text-center">${vo.msg }</td>
		</tr>
		<tr>
			<th class="text-center">주소</th>
			<td class="text-center">${vo.address }</td>
		</tr>
		<tr>
			<th class="text-center">조회수</th>
			<td class="text-center">${vo.hit }</td>
		</tr>
	</table>
	
</body>
</html>