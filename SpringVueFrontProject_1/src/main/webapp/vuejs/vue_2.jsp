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
  <div id="app">
    {{ name }}<br>
    <button @click="changeText">Click!</button>
  </div>

  <div id="app-2">
    {{ name }}<br>
    <button @click="changeText">Click!</button>
  </div>

  <script>
    const AppComponent = {
      data() {
        return {
          name: 'Jang'
        }
      },
      methods: {
        changeText() {
          this.name = 'Jang-change';
        }
      }
    }

    Vue.createApp(AppComponent).mount('#app');
    Vue.createApp(AppComponent).mount('#app-2');
  </script>
</body>

</body>
</html>