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
<style type="text/css">
.container{
	margin-top:50px;
}
.row {
	width: 960px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">사원 목록</h3>
			<table class="table">
				<tr>
					<th class="text-center">사번</th>
					<th class="text-center">이름</th>
					<th class="text-center">성별</th>
					<th class="text-center">부서</th>
					<th class="text-center">근무지</th>
				</tr>
				<tr v-for="vo in sawon" v-on:click="detail(vo)" >
					<td class="text-center">{{vo.sabun}}</td>
					<td class="text-center">{{vo.name}}</td>
					<td class="text-center">{{vo.sex}}</td>
					<td class="text-center">{{vo.dept}}</td>
					<td class="text-center">{{vo.loc}}</td>
				</tr>
			</table>
		</div>
		<div class="row">
			<table class="table" v-show="isShow" >
				<tr>
					<td class="text-center">사번</td>
					<td class="text-center">{{detail_data.sabun}}</td>
				</tr>
				<tr>
					<td class="text-center">이름</td>
					<td class="text-center">{{detail_data.name}}</td>
				</tr>
				<tr>
					<td class="text-center">성별</td>
					<td class="text-center">{{detail_data.sex}}</td>
				</tr>
				<tr>
					<td class="text-center">부서</td>
					<td class="text-center">{{detail_data.dept}}</td>
				</tr>
				<tr>
					<td class="text-center">근무지</td>
					<td class="text-center">{{detail_data.loc}}</td>
				</tr>
			</table>
		</div>
	</div>
<script >
	let app=Vue.createApp({
		data(){
			return{
				sawon:[
					{"sabun":1,"name":"홍길동","sex":"남자","dept":"개발부","loc":"서울"},
					{"sabun":2,"name":"홍길동2","sex":"남자","dept":"개발부","loc":"서울2"},
					{"sabun":3,"name":"홍길동3","sex":"남자","dept":"개발부","loc":"서울3"},
					{"sabun":4,"name":"홍길동4","sex":"남자","dept":"개발부","loc":"서울4"},
					{"sabun":5,"name":"홍길동5","sex":"남자","dept":"개발부","loc":"서울5"}
				],
				isShow:false,
				detail_data:{}
			}
		},
		methods:{
			detail(vo){
				this.isShow=true
				this.detail_data=vo
			}
		}
	}).mount(".container")
</script>
</body>
</html>