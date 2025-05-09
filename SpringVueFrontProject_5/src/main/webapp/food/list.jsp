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
  width: 960px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.page-btn{
	cursor:pointer;
}
</style>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="text-center">
				<input type="button" value="한식" class="btn-lg btn-success" @click="food('한식')">
				<input type="button" value="양식" class="btn-lg btn-info" @click="food('양식')">
				<input type="button" value="중식" class="btn-lg btn-warning" @click="food('중식')">
				<input type="button" value="일식" class="btn-lg btn-danger" @click="food('일식')">
			</div>
		</div>
	<div style="height:10px"></div>
<div class="row">
		<h3 class="text-center">{{type}}</h3>
			<div class="col-md-3" v-for="vo in list">
   			 <div class="thumbnail">
      			<a :href="'../food/detail.do?fno='+vo.fno">
        			<img :src="'https://www.menupan.com'+vo.poster" alt="Lights" style="width:230px;height: 150px">
        			<div class="caption">
          				<p>{{vo.name}}</p>
        			</div>
      			</a>
    		</div>
  		</div>
		</div>
			<div style="height:10px"></div>
		<div class="row">
		<div class="text-center">
			<ul class="pagination">
				<li v-if="startPage>1"><a class="page-btn" @click="prev()" >&laquo;</a></li>
				<li v-for="i in range(startPage,endPage)" :class="i===curpage? 'active':''" ><a class="page-btn" @click="pageChange(i)">{{i}}</a></li>
				<li v-if="endPage<totalpage" ><a class="page-btn" @click="next()" >&raquo;</a></li>
			</ul>
		</div>
		</div>
</div>
<script src="page.js"></script>
</body>
</html>