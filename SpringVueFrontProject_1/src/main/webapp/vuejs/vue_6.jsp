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
<div class="container" id="app1">
	<div class="row">
		<h3 class="text-center">v-if~v-else-if~v-else</h3>
		<button class="btn-sm btn-danger" @click="select(1)" >한식</button>
		<button class="btn-sm btn-info" @click="select(2)">중식</button>
		<button class="btn-sm btn-success" @click="select(3)">일식</button>
		<button class="btn-sm btn-warning" @click="select(4)">양식</button>
		<button class="btn-sm btn-default" @click="select(5)">분식</button>
	</div>
	<div style="height:10px" ></div>
	<div class="row">
		<div v-if="type===1">한식</div>
		<div v-else-if="type===2" >중식</div>
		<div v-else-if="type===3" >일식</div>
		<div v-else-if="type===4" >양식</div>
		<div v-else-if="type===5" >분식</div>
		<div v-else>음식을 선택해주세요</div>
	</div>
</div>
<div class="container" id="app2">
	<button class="btn-sm btn-success" @click="loginBtn(true)" >로그인</button>
	<button class="btn-sm btn-danger" @click="loginBtn(false)">로그아웃</button>
	<div v-if="login===true">로그인됨</div>
	<div v-else>로그아웃됨</div>
</div>
<script>
	const app = Vue.createApp({
		data(){
			return{
				type:0
			}
		},
		methods:{
			select(no){
				this.type=no
			}
		}
	}).mount("#app1")
	const app2=Vue.createApp({
		data(){
			return{
				login:false
			}
		},
		methods:{
			loginBtn(check){
				this.login=check;
			}
		}
	}).mount("#app2")
</script>
</body>
</html>