<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	StringBuilder sb = new StringBuilder();


	/* request 내장 객체를 이용한 요청 파라미터 수신 */
	/* 주의) name="" 속성의 식별자 사용 */
	/* 주의) 동일자료 동일식별자 */
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	

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

	<h1>내장객체-request</h1>
	
	<h2>데이터 수신 결과 - <%=name%>, <%=phone%></h2>
	
</div>

</body>
</html>