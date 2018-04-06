<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	int sum = 0;
	for (int i=1; i<=10; ++i) {
		sum = sum + i;
	}
	
	int sum2 = 0;
	for (int i=11; i<=20; ++i) {
		sum2 = sum2 + i;
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
		<h1>JSP Scriptlet</h1>
		<p>
			1부터 10까지의 합은	<%=sum%>입니다.
		</p>
		<p>
			11부터 20까지의 합은 <%=sum2%>입니다.
		</p>
	</div>

</body>
</html>