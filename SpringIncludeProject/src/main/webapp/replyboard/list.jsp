<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

			<h3 class="text-center">SPRING를 이용한 게시판</h3>
			<table class="table">
				<tr>
					<td><a href="insert.do" class="btn btn-sm btn-primary">새글</a></td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<th width=10% class="text-center">번호</th>
					<th width=45% class="text-center">제목</th>
					<th width=15% class="text-center">이름</th>
					<th width=20% class="text-center">작성일</th>
					<th width=10% class="text-center">조회수</th>
				</tr>
				<c:forEach var="vo" items="${list }" >
					<tr>
						<td widtd=10% class="text-center">${vo.no }</td>
						<td widtd=45% >
						<c:if test="${vo.group_tab>0 }">
							<c:forEach var="i" begin="1" end="${vo.group_tab }">
							&nbsp;&nbsp;
							</c:forEach>
							<img src="../replyboard/re_icon.png">
						</c:if>
						<c:if test="${vo.subject!=msg }">
						<a href="../board/detail.do?no=${vo.no }">${vo.subject }</a>
						</c:if>
						<c:if test="${vo.subject==msg }">
						<span style="color:gray">${vo.subject }</span>
						</c:if>
						</td>
						<td widtd=15% class="text-center">${vo.name }</td>
						<td widtd=20% class="text-center">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd" />
						</td>
						<td widtd=10% class="text-center">${vo.hit }</td>
					</tr>
				</c:forEach>
				 <tr>
         <td colspan="5" class="text-center">
          <a href="../board/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-success">이전</a>
           ${curpage } page / ${totalpage } pages
          <a href="../board/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-info">다음</a>
         </td>
       </tr>
			</table>

</body>
</html>