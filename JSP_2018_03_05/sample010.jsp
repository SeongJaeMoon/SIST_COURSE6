<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	
	/*
	문제) 석차 알고리즘 적용 결과 출력. names, scores, ranks 1차원 배열 준비.
	출력예)
	이름 점수 석차
	--------------
	hong 100  1
	park 90   3
	choi 95   2
	kim  80   5
	lee  85   4
	*/
	
	StringBuilder sb = new StringBuilder();
	
	String[] names = {"hong", "park", "kim", "lee", "choi"};
	int namesLen = names.length;
	int[] scores = new int[namesLen];
	int[] ranks = new int[namesLen];
	for (int a=0; a<namesLen; ++a) {
		scores[a] = (int)(Math.random()*101);
		ranks[a] = 1;
	}
	
	for (int i = 0; i < namesLen; ++i) {
		for (int j = 0; j < namesLen; ++j) {
			if (scores[i] < scores[j]) {
				ranks[i] += 1;
			}
		}
	}
	
	sb.append("<table class=\"table table-striped\">");
	sb.append("<thead><tr><th>이름</th><th>점수</th><th>석차</th></tr></thead>");
	sb.append("<tbody>");
	for (int i = 0; i < namesLen; ++i) {
		sb.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", names[i], scores[i], ranks[i]));
	}
	sb.append("</tbody>");
	sb.append("</table>");
	
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
<h1>석차 알고리즘</h1>
<%=sb.toString()%>
</div>

</body>
</html>