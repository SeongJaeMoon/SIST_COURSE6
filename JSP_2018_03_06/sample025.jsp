<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	StringBuilder sb = new StringBuilder();

	/* request 내장 객체를 이용한 클라이언트 정보 분석 */

	sb.append("<table class=\"table\">");
	sb.append("<thead><tr><th>Name</th><th>Value(s)</th></tr></thead>");
	sb.append("<tbody>");
	sb.append(String.format("<tr><td>클라언트IP</td><td>%s</td></tr>", request.getRemoteAddr()));
	sb.append(String.format("<tr><td>요청정보프로토콜</td><td>%s</td></tr>", request.getProtocol()));
	sb.append(String.format("<tr><td>요청정보전송방식</td><td>%s</td></tr>", request.getMethod()));
	sb.append(String.format("<tr><td>요청정보콘텐츠타입</td><td>%s</td></tr>", request.getContentType()));
	sb.append(String.format("<tr><td>요청정보콘텐츠길이</td><td>%s</td></tr>", request.getContentLength()));
	sb.append(String.format("<tr><td>요청URL</td><td>%s</td></tr>", request.getRequestURL()));
	sb.append(String.format("<tr><td>요청URI</td><td>%s</td></tr>", request.getRequestURI()));
	sb.append("<tbody>");
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
	<h1>request 내장 객체를 이용한 클라이언트 정보 분석</h1>
	<div>
		<%=sb.toString()%>
	</div>
</div>

</body>
</html>