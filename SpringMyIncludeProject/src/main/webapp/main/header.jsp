<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Spring Example</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">서울
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../seoul/find.do">서울음식 검색</a></li>
        </ul>
      </li>
      <li><a href="#">채팅</a></li>
      <li><a href="../board/list.do">답변형 게시판</a></li>
    </ul>
  </div>
</nav>
</body>
</html>