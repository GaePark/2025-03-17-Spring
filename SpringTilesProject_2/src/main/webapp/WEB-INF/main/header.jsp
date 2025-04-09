<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="index.html">Food & Recipe</a></h1>
    </div>
    <div class="fl_right">
      <ul class="inline">
        <li><i class="fa fa-phone"></i> 로그인</li>
        <li><i class="fa fa-envelope-o"></i> 보안(권한부여,자동로그인)</li>
      </ul>
    </div>
  </header>
</div>
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <ul class="clear">
      <li class="active"><a href="index.html">Home</a></li>
      <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="pages/gallery.html">회원가입</a></li>
          <li><a href="pages/full-width.html">아이디 찾기</a></li>
          <li><a href="pages/sidebar-left.html">비밀번호 찾기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="pages/gallery.html">레시피목록</a></li>
          <li><a href="pages/full-width.html">레시피 검색</a></li>
          <li><a href="pages/sidebar-left.html">쉐프</a></li>
        </ul>
      </li>
      
      <li><a href="#">채팅</a></li>
      <li><a href="#">Session / Cookie</a></li>
      <li><a href="#">Calendar</a></li>
    </ul>
  </nav>
</div>
<div class="wrapper row3">
  <div id="slider" class="clear"> 
    <div class="flexslider basicslider">
      <ul class="slides">
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back1.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back2.jpg" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="../images/demo/slides/back3.jpg" style="width:978px;height:400px"></a></li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>