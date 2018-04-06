<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	//중첩 if문

	//입력과정 ----------------------
	//변수의 초기값을 난수(0~99)로 채운다
	int score = (int) (Math.random() * 100);

	//처리과정 ----------------------
	//처리 과정의 결과를 저장하기 위한 임시 변수
	String result = "";
	if (score >= 90) {
		if (score >= 95) {
			result = "A+";
		} else {
			result = "A";
		}
	} else if (score >= 80) {
		if (score >= 85) {
			result = "B+";
		} else {
			result = "B";
		}
	} else if (score >= 70) {
		if (score >= 75) {
			result = "C+";
		} else {
			result = "C";
		}
	} else {
		result = "D";
	}

	//출력과정----------------------
	/* 
	System.out.println("점수는 " + score + " 입니다.");
	System.out.println("등급은 " + result + " 입니다.");
	*/
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
		<p>
			점수는 <%=score%> 입니다.
		</p>
		<p>
			등급은 <%=result%> 입니다.
		</p>
	</div>

</body>
</html>