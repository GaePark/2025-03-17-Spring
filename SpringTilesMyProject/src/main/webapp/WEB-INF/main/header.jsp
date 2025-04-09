<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="index.html">Splash <em>.</em></a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="features.html">Home</a></li>
						<li class="has-dropdown">
							<a href="#">회원</a>
							<ul class="dropdown">
								<li><a href="#">회원가입</a></li>
								<li><a href="#">아이디 찾기</a></li>
								<li><a href="#">비밀번호 찾기</a></li>
							</ul>
						</li>
						<li class="has-dropdown">
							<a href="#">레시피</a>
							<ul class="dropdown">
								<li><a href="#">레시피 목록</a></li>
								<li><a href="#">레시피 검색</a></li>
								<li><a href="#">쉐프 목록</a></li>
							</ul>
						</li>
						<li><a href="pricing.html">채팅</a></li>
						<li><a href="contact.html">Session/Cookies</a></li>
						<li><a href="contact.html">Calendar</a></li>
						<li class="btn-cta"><a href="#"><span>로그인</span></a></li>
					</ul>
				</div>
			</div>
			
		</div>
	</nav>
	
	<header id="gtco-header" class="gtco-cover" role="banner" style="background-image: url(images/img_4.jpg)">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">Welcome to Splash</span>
							<h1>Build website using this template.</h1>	
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									<ul class="tab-menu">
										<li class="active gtco-first"><a href="#" data-tab="signup">Sign up</a></li>
										<li class="gtco-second"><a href="#" data-tab="login">Login</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<form action="#">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="username">Username or Email</label>
														<input type="text" class="form-control" id="username">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password">Password</label>
														<input type="password" class="form-control" id="password">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password2">Repeat Password</label>
														<input type="password" class="form-control" id="password2">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary" value="Sign up">
													</div>
												</div>
											</form>	
										</div>

										<div class="tab-content-inner" data-content="login">
											<form action="#">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="username">Username or Email</label>
														<input type="text" class="form-control" id="username">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password">Password</label>
														<input type="password" class="form-control" id="password">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary" value="Login">
													</div>
												</div>
											</form>	
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
							
					
				</div>
			</div>
		</div>
	</header>
</body>
</html>