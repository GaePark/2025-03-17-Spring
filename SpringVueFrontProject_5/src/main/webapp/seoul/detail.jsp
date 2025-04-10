<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
</style>
</head>
<body>
<div class="container">
	<div class="row">
	<table class="table">
		<tr>
			<td class="text-center">
				<img :src="vo.poster" style="width:750px;height:350px">
			</td>
		</tr>
		<tr>
			<td class="text-center"><h3 id="name">{{vo.title}}</h3></td>
		</tr>
		<tr>
			<td>{{vo.msg}}</td>
		</tr>
		<tr>
			<td id="address">{{vo.address}}</td>
		</tr>
	</table>
	</div>
<div id="map" style="width:100%;height:350px;"></div>
</div>



<script>
	const detailApp=Vue.createApp({
		data(){
			return{
				no:${param.no},
				type:${param.type},
				vo:{},
				address:""
			}	
		},
		mounted(){
			this.dataRecv()
		},
		methods:{
			dataRecv(){
				axios.get("http://localhost:8080/web/seoul/detail_vue.do",{
					params:{
						no:this.no,
						type:this.type
					}
				})
				.then(res=> {
					console.log(res.data)
					this.vo=res.data.vo
					this.address=res.data.address
					if(window.kakao &&window.kakao.maps)
						{
						this.initMap()
						}
					else
						{
							this.addScript()
						}
				})
				.catch(err => {
					console.log(err)
				})
			},
			addScript(){
				const script = document.createElement("script")
				script.src="//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e18e45dac34bf01c39c8e26f99e1f226&libraries=services"
				script.onload=()=>kakao.maps.load(this.initMap)
				document.head.appendChild(script)
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
			console.log($('#address').text())
			geocoder.addressSearch(this.address, function(result, status) {

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
			});    
			}
		}
	}).mount(".container")
</script>
</body>
</html>