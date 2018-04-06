<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	/* 
	문제) 가위, 바위, 보 게임
	난수로 발생된 1~3의 숫자를 가지고 가위, 바위, 보 출력하고
	, 승자가 누구인지 출력.
	무한 반복하되, user1, user2가 비긴 경우가 발생하면 반복 중단.
	출력예)
	가위, 바위, 보 게임
	-------------------
	user1:가위,  user2:바위 -> user2 승!
	...
	user1:가위,  user2:가위 -> 비겼습니다.
	프로그램 종료.
	*/
	
	String[] array = { "", "가위", "바위", "보" };
	StringBuilder sb = new StringBuilder();
	String result = "비겼습니다.";
	
	while(true) {
		int user1 = (int) (Math.random() * 3) + 1;
		int user2 = (int) (Math.random() * 3) + 1;
		if (user1 == user2) {
			result = "비겼습니다.";
		} else {
			if ((user1 % 3) == ((user2 + 1) % 3)) {
				result = "user1 승!";			
			}else {
				result = "user2 승!";			
			}
		}
		sb.append(String.format("user1:%s, user2:%s", array[user1], array[user2]));
		sb.append(String.format("-> %s<br>", result));
		if (user1 == user2) {
			sb.append("프로그램 종료.");
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
		<h1>가위, 바위, 보 게임</h1>
		<p>난수로 발생된 1~3의 숫자를 가지고 가위, 바위, 보 출력하고 , 승자가 누구인지 출력. 무한 반복하되,
			user1, user2가 비긴 경우가 발생하면 반복 중단.</p>
		<p><%=sb.toString()%></p>
	</div>

</body>
</html>