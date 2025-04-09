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
			<table class="table">
				<tr>
					<th>번호</th>
					<th></th>
					<th>제목</th>
				</tr>
				<tr v-for="vo in list" >
					<th>{{vo.no}}</th>
					<th>
						<img :src="vo.poster" style="width:35px;height:35px">
					</th>
					<th>{{vo.title}}</th>
				</tr>
			</table>
		</div>
	</div>
	<script>
		const app=Vue.createApp({
			data(){
				return{
				list:[]
				}
			},
			mounted(){
				axios.get("http://localhost:8080/web/recipe/list_vue.do")
				.then(res => {
					this.list=res.data
				})
				.catch(err => {
					console.log(err)
				})
			}
		}).mount(".container")
	</script>
</body>
</html>