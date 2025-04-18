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
	width: 800px;
}
</style>
</head>
<body>
	<div class="container" id="app">
		<div class="row">
		<table class="table">
			<tr>
				<td class="text-center" colspan="3">
					<img :src="vo.poster" style="width: 750px;height:300px;">
				</td>
			</tr>
			<tr>
				<td class="text-center" colspan="3">
				<h3 id="name" >{{vo.title}}</h3>
				</td>
			</tr>
			<tr>
				<td class="text-center" colspan="3">
				<span style="color:gray">{{vo.msg}}</span>
				</td>
			</tr>
			<tr>
				<td class="text-center" colspan="3">
				<span style="color:gray">{{vo.address}}</span>
				</td>
			</tr>
			
		</table>
		</div>
		<div class="row">
		<h3>인근 맛집</h3>
		<div class="col-sm-3" v-for="fvo in list">
			<img :src="'http://www.menupan.com'+fvo.poster" style="width:100%">
			<p class="text-center">{{fvo.name}}</p>
		</div>
		</div>
		<div class="row">
		<div id="map" style="width:100%;height:350px;"></div>
		</div>
	</div>
<script type="module" >
	import {createApp} from "https://unpkg.com/vue@3/dist/vue.esm-browser.js"
   import axiosClient from "../js/api.js"

	const params = new URLSearchParams(window.location.search);
  	const no = params.get("no");
	const app=createApp({
		data(){
			return{
				no:no,
				vo:{},
				table_name:'${table_name}',
				list:[]	
			}
		},
		mounted(){
			this.dataRecv()
			if(window.kakao &&window.kakao.maps)
				{
				this.initMap()
				}
				else
				{
					this.addScript()
				}
		},
		methods:{
			async dataRecv(){
				const res = await axiosClient.get('seoul/detail_vue.do',{
					params:{
						no:this.no,
						table_name:this.table_name
					}
				})
				console.log(res.data)
				this.vo=res.data.vo
				this.list=res.data.list
			},
			initMap(){
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(this.vo.address, function(result, status) {

			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {

			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });

			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
			        });
			        infowindow.open(map, marker);

			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			}) 
			},
			addScript(){
				const script = document.createElement("script")
				script.src="//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e18e45dac34bf01c39c8e26f99e1f226&libraries=services"
				script.onload=()=>kakao.maps.load(this.initMap)
				document.head.appendChild(script)
			}
		}
	})
	app.mount("#app")
</script>
</body>
</html>