<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. 생성
	2. 이벤트 처리
	3. 생명주기
	4. 출력
	5. 재사용
	6. 출력 / 이벤트 등록
	   HTML안에서 처리
	   -------------
	   화면 출력 => <태그>{{변수명}}</태그>
	                   --------[[]] => 변경
	                   => 장고 {{}}
	              <태그 : 속성="변수명">
	              <태그 v-bind:속성="변수명">
	   ---------------------------------- 디렉티브 v-
	   
	   제어문
	       반복문 => 반복되는 태그안에 설정
	       <태그 vat for-
	   이벤트 등록
--%>
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
		<div class="col-md-3" v-for="vo in list">
    <div class="thumbnail">
      <a :href="'../recipe/detail.do?no='+vo.no">
        <img :src="vo.poster" alt="Lights" style="width:230px;height: 150px">
        <div class="caption">
          <p>{{vo.title}}</p>
        </div>
      </a>
    </div>
  </div>
		</div>
		<div style="height:10px"></div>
		<div class="row">
		<div class="text-center">
		<input type=button class="btn-sm btn-danger" value="이전" @click="prev()" >
		{{curpage}} page/ {{totalpage}} pages
		<input type=button class="btn-sm btn-danger" value="다음" v-on:click="next()" >
		</div>
		</div>
	</div>
	<script>
		const app=Vue.createApp({
			data(){
				return{
					list:[],
					curpage:1,
					totalpage:0
				}
			},
			mounted(){
				this.dataRecv()
				
			},
			methods:{
				prev(){
						this.curpage=this.curpage>1?this.curpage-1:this.curpage
						this.dataRecv()
				},
				next(){
					this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
						this.dataRecv()
				},
				dataRecv(){
					axios.get("http://localhost:8080/web/recipe/list_vue.do",{
						params:{
							page:this.curpage
						}
					})
					.then(res => {
						console.log(res.data)
						this.list=res.data.list
						this.totalpage=res.data.totalpage
					})
					.catch(err => {
						console.log(err.response)
					})
				}
			}
		}).mount(".container")
	</script>
</body>
</html>