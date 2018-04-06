<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	StringBuilder sb = new StringBuilder();


	/* request 내장 객체를 이용한 헤더 정보 분석 */
	java.util.Enumeration<String> headerNames = request.getHeaderNames();
	sb.append("<table class=\"table\">");
	sb.append("<thead><tr><th>Header Name</th><th>Header Value(s)</th></tr></thead>");
	sb.append("<tbody>");
	while (headerNames.hasMoreElements()) {
		String paramName = (String) headerNames.nextElement();
		sb.append("<tr><td>" + paramName + "</td>\n");
		String paramValue = request.getHeader(paramName);
		sb.append("<td> " + paramValue + "</td></tr>\n");
	}
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

	<h1>request 내장 객체를 이용한 헤더 정보 분석</h1>
	<div>
		<%=sb.toString()%>
	</div>

</div>

</body>
</html>