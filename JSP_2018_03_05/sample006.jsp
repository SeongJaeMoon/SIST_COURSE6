<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	//반복문 테스트

	//1부터 100까지의 수에 대한 합산을 출력하되, 아래 형태로 출력.
	//-> 숫자 출력시 10단위마다 줄바꿈 출력
	/*
	출력예)
	 1 2 3 4 5 6 7 8 9 10
	 11 12 13 14 15 16 17 18 19 20
	 ...
	 91 92 93 94 95 96 97 98 99 100
	 ------------------
	 5050
	*/

	StringBuilder sb = new StringBuilder();
	int temp = 0;

	//1부터 100까지의 수 변화
	for (int a = 1; a <= 100; ++a) {

		//합산
		temp = temp + a;

		//수 출력
		//System.out.print(" " + a);
		sb.append(" " + a);

		//줄바꿈 문자 출력
		if (a % 10 == 0) {
			//System.out.print("\n");
			sb.append("<br>");
		}
	}

	/* 
	System.out.println("----------------");
	System.out.println(temp);
	*/
	sb.append("-------------------<br>");
	sb.append(temp);
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
<%=sb.toString()%>
</div>

</body>
</html>