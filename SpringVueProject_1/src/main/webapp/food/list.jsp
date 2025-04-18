<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 960px;
}
p{
	overflow:hidden;
	white-space:nowrap;
	text-overflow: ellipsis;
}
.nav-link{
cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		
		<div class="row">
			<div class="col-sm-3" v-for="vo in list">
				<div class="thumbnail">
					<a :href="'../food/detail.do?fno='+vo.fno">
					<img :src="'https://www.menupan.com'+vo.poster" style="width:230px;height:130px">
					<p>{{vo.name}}</p>
					</a>
				</div>
			</div>
		</div>
		<div style="height:10px"></div>
		<div class="row text-center">
			<ul class="pagination">
				<li v-if="startPage>1" @click="prev()"><a class="nav-link">&lt;</a></li>
				<li :class="curpage===i?'active':''" v-for="i in range(startPage,endPage)" @click="pageChange(i)"><a class="nav-link">{{i}}</a></li>
				<li v-if="endPage<totalpage" @click="next()"><a class="nav-link">&gt;</a></li>
			</ul>
		</div>
	</div>
	<script type="importmap">
	{
		"imports":{
           "vue":"https://unpkg.com/vue@3/dist/vue.esm-browser.js"
         }
	}
	</script>
	<script type="module">
	import {createApp} from "vue"
	import axiosClient from "../js/api.js"
	const app=createApp({
	data(){
		return{
			list:[],
			curpage:1,
			totalpage:0,
			endPage:0,
			startPage:0,
		}	
	},
	mounted(){
		this.dataRecv()
	},
	methods:{
		prev(){
			this.curpage=this.startPage-1
			this.dataRecv()
		},
		next(){
			this.curpage=this.endPage+1
			this.dataRecv()
		},
		pageChange(i){
			this.curpage=i
			this.dataRecv()
		},
		range(start, end){
			let arr=[]
			let len=end-start
			for(let i=0;i<=len;i++)
			{
				arr[i]=start
				start++
			}
			return arr
		},
		async dataRecv(){
			const res=await axiosClient.get('food/list_vue.do',{
				params:{
						page:this.curpage
				}
			})
			console.log(res)
			this.list=res.data.list
			this.totalpage=res.data.totalpage
			this.startPage=res.data.startPage
			this.endPage=res.data.endPage
		}
	}
	})
	app.mount('.container')
	</script>
</body>
</html>