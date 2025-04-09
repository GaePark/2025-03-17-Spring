<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container" id="app1">
	<div class="row">
	<table class="table">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>직위</td>
			<td>급여</td>
			<td>입사일</td>
		</tr>
		<tr v-for="vo in ld.emp" >
			<td>{{vo.empno}}</td>
			<td>{{vo.ename}}</td>
			<td>{{vo.job}}</td>
			<td>{{vo.sal}}</td>
			<td>{{vo.dbday}}</td>
		</tr>
	</table>
	</div>
	<div class="row" >
		<h3>부서정보</h3>
		<table class="table">
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>근무지</th>
			</tr>
			<tr v-for="vo in ld.dept">
				<td>{{vo.deptno}}</td>
				<td>{{vo.dname}}</td>
				<td>{{vo.loc}}</td>
			</tr>
		</table>
	</div>
</div>

<script>
	const app = Vue.createApp({
		data(){
			return{
				ld:{}
			}
		},
		mounted(){
			axios.get("http://localhost:8080/web/emp/elist_vue.do")
				.then(res => {
					this.ld=res.data;
					console.log(res)
				})
				.catch(err => {
					console.error("에러"+err)
				})
		}
	}).mount(".container")
</script>
</body>
</html>