<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	//반복문 테스트

	//두 개의 주사위를 던져서 나온 수의 합이 일정 수가 아니면 무한 반복 및 출력. 
	//일정 수(합이 5인 경우)이면 무한 반복 탈출.
	//반복문, if문, 탈출문, 난수(1~6) 발생.

	StringBuilder sb = new StringBuilder();
	while (true) {

		int dice1 = (int) (Math.random() * 6) + 1;

		int dice2 = (int) (Math.random() * 6) + 1;

		//System.out.println("(" + dice1 + "+" + dice2 + ")=" + (dice1 + dice2));
		sb.append("(" + dice1 + "+" + dice2 + ")=" + (dice1 + dice2) + "<br>");
		
		if (dice1 + dice2 == 5) {
			break;
		}

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SIST_쌍용교육센터</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
		<h1>반복문 테스트</h1>

		<p>두 개의 주사위를 던져서 나온 수의 합이 일정 수가 아니면 무한 반복 및 출력. 일정 수(합이 5인 경우)이면
			무한 반복 탈출. 반복문, if문, 탈출문, 난수(1~6) 발생.</p>
		<p><%=sb.toString()%></p>

	</div>

</body>
</html>