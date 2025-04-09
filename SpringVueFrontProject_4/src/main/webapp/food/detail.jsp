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
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<table class="table">
			<tr>
				<td rowspan="8" width="50%" class="text-center" >
					<img :src="'https://www.menupan.com'+vo.poster" width="100%">
				</td>
				<td width="20%">업체명</td>
				<td width="30%">{{vo.name}}</td>
			</tr>
			<tr>
				<td width="20%">종류</td>
				<td width="30%">{{vo.type}}</td>
			</tr>
			<tr>
				<td width="20%">전화번호</td>
				<td width="30%">{{vo.phone}}</td>
			</tr>
			<tr>
				<td width="20%">주소</td>
				<td width="30%">{{vo.address}}</td>
			</tr>
			<tr>
				<td width="20%">테마</td>
				<td width="30%">{{vo.theme}}</td>
			</tr>
			<tr>
				<td width="20%">시간</td>
				<td width="30%">{{vo.time}}</td>
			</tr>
			<tr>
				<td width="20%">주차</td>
				<td width="30%">{{vo.parking}}</td>
			</tr>
			<tr>
				<td width="20%">가격</td>
				<td width="30%">{{vo.price}}</td>
			</tr>
		</table>
		<table class="table">
			<tr>
				<td>{{vo.content}}</td>
			</tr>
		</table>
		
	</div>
</div>
<script>
	const app = Vue.createApp({
		data(){
			return {
				fno:${param.fno},
				vo:{}
				
			}
		},
		mounted(){
			axios.get("../food/detail_vue.do",{
				params:{
					fno:this.fno
				}
			})
			.then(res=> {
				console.log(res.data)
				this.vo=res.data
			})
			.catch(err=>{
			console.log(err.response)
			})
		},
		methods:{
			
		}
	}).mount(".container")
</script>
</body>
</html>