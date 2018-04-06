<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	StringBuilder sb = new StringBuilder();

	//배열의 배열
	/*
	문제) 출력 형태가 아래와 같이 되도록 2차원 배열 초기화
	
	 5  4  3  2  1  
	 6  7  8  9 10
	15 14 13 12 11 
	16 17 18 19 20
	25 24 23 22 21 
	
	*/

	int[][] arr = new int[5][5];
	
	int c = 0;
	int len = arr.length;
	for (int a = 0; a < len; ++a) {
		int temp = arr[a].length;
		for (int b = 0; b < temp; ++b) {
			if (a % 2 == 0) {
				arr[a][temp - b - 1] = ++c;
			} else {
				arr[a][b] = ++c;
			}
		}
	}
	
	//배열의 배열을 2차원 구조로 출력
	sb.append("<table id=\"table01\"><tbody>");
	for (int a = 0; a < arr.length; ++a) {
		sb.append("<tr>");
		for (int b = 0; b < arr[a].length; ++b) {
			sb.append(String.format("<td>%d</td>", arr[a][b]));
		}
		sb.append("</tr>");
	}
	sb.append("</tbody></table>");
	
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
table#table01 td {
	text-align: right;
	padding: 5px;
}
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
	<h1>배열의 배열</h1>
	<p><%=sb.toString()%></p>
</div>

</body>
</html>