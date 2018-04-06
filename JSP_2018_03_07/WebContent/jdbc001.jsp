<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*" %>
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	StringBuilder sb = new StringBuilder();
	
	//1단계. JDBC 드라이버 로딩
	Class.forName("com.mysql.jdbc.Driver");
	
	//2단계. 데이터베이스 커넥션 생성
	Connection conn = DriverManager.getConnection("jdbc:mysql://211.63.89.XX:3306/project01?useSSL=false", "아이디", "패스워드");
	
	
	
	//7단계. 커넥션 종료.
	conn.close();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SIST_쌍용교육센터</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>

</style>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script>
$(document).ready(function(){

	   // jQuery methods go here...

});
</script>
</head>
<body>

<div class="container">
	<h1>데이터베이스 연결 테스트</h1>
</div>

</body>
</html>