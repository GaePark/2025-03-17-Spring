<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>상세보기</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row justify-content-center">
            	<form method="post" action="../member/login.do" id="frm">
            	<table class="table">
            		<tr>
            		<th width="20%">ID</th>
            		<td width="80%">
            		<input type="text" name="userid" class="input-sm" ref="userid" v-model="userid">
            		</td>
            		</tr>
            		<tr>
            		<th width="20%">PWD</th>
            		<td width="80%">
            		<input type="password" name="userpwd" class="input-sm" ref="userpwd" v-model="userpwd">
            		</td>
            		</tr>
            		<tr>
            		<td colspan="2">
            		<input type="checkbox" value="remember-me" >자동로그인
            		</td>
            		</tr>
            		<tr>
            			<td colspan="2" class="text-center">
            				<span style="color:red">${message }</span>
            			</td>
            		</tr>
            		<tr>
            			<td colspan="2">
            				<input type="button" value="로그인" class="btn-sm btn-danger">
            				<input type="button" value="취소" class="btn-sm btn-success">
            			</td>
            		</tr>
            	</table>
            	</form>
            </div>
        </div>
    </div>
</body>
</html>