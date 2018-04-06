<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//JSP code
	StringBuilder sb = new StringBuilder();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SIST_쌍용교육센터</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
</style>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script>
	$(document).ready(function() {

		// jQuery methods go here...

	});
</script>
</head>
<body>

	<div class="container">

		<h1>내장객체-request</h1>

		<!-- 서버는 송신된 데이터를 수신하고, 자동으로 지정된 JSP 페이지를 요청 -->
		<!-- action="서버측프로그램주소" method="전송방식" 속성 필수 항목 -->
		<form action="sample023_receive.jsp" method="post">
			<div class="form-group">
				<label for="name">이름:</label>
				<!-- 서버에 전송하고자 하는 자료를 입력할 수 있는 폼 구성 -->
				<!-- 동일자료 동일식별자 -->
				<!-- name="" 속성 필수 항목 -->
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="phone">전화번호:</label>
				<!-- 서버에 전송하고자 하는 자료를 입력할 수 있는 폼 구성 -->
				<!-- 동일자료 동일식별자 -->
				<!-- name="" 속성 필수 항목 -->
				<input type="text" class="form-control" id="phone" name="phone">
			</div>

			<div class="form-group">
				<label for="subject">강의가능과목:</label>
				<div>	
					<label class="checkbox-inline">
					
					<!-- value="" name="" 속성 필수 항목 -->
					<!-- 주의) checkbox는 체크된 항목만 서버로 전송된다. 자료형은 String[] 이다. --> 
					<input type="checkbox"
						value="S001" name="subject">Java SE</label>
						 
					<label class="checkbox-inline"><input
						type="checkbox" value="S002" name="subject">Oracle</label> 
					<label
						class="checkbox-inline"><input 
						type="checkbox" value="S003" name="subject">JDBC</label>
				</div>
			</div>

			<!-- 서브밋 버튼 클릭시 폼에 입력된 정보를 서버로 전송 -->
			<!-- type="submit" 속성 필수 항목 -->
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

	</div>

</body>
</html>