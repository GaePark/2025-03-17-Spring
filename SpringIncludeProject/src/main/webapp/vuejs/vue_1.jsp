<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!-- <script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let msg = $(this).val()
		$('#print').text(msg)
	})
})
</script> -->
</head>
<body>
  <div id="container" >
    <input type="text" v-model="msg" />
    <div>{{ msg }}</div>
  </div>

  <script>
    const app = Vue.createApp({
      data() {
        return {
          msg: ''
        };
      }
    }).mount('#container');
  </script>
</body>
</html>