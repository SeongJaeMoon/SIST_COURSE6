<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	StringBuilder sb = new StringBuilder();
	
	String num = request.getParameter("num");
	if (num == null) {
		num = "1";
	}
	
	for (int a=1; a<=9; ++a) {
		sb.append(String.format("%s * %s = %s<br>", num, a, (Integer.parseInt(num) * a)));
	}
	
	String eq = String.valueOf(Integer.parseInt(num) - 1);
	
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
		
		$("button").on("click", function() {
			$("input#num").val(($(this).index() + 1));
			$("form#myForm").submit();
		});
		
		$("button").eq(<%=eq%>).addClass("active");

	});
</script>
</head>
<body>

	<div class="container">
		<h1>POST 방식 요청을 이용한 구구단 출력</h1>
		<div class="btn-group" style="margin-top: 20px;">
			<button type="button" class="btn btn-default">1단</button>
			<button type="button" class="btn btn-default">2단</button>
			<button type="button" class="btn btn-default">3단</button>
			<button type="button" class="btn btn-default">4단</button>
			<button type="button" class="btn btn-default">5단</button>
			<button type="button" class="btn btn-default">6단</button>
			<button type="button" class="btn btn-default">7단</button>
			<button type="button" class="btn btn-default">8단</button>
			<button type="button" class="btn btn-default">9단</button>
		</div>
		<div>
			<h3>
			<!-- 
				1 * 1 = 1<br> 1 * 2 = 2<br> 1 * 3 = 3<br> 1 * 4 = 4<br>
				1 * 5 = 5<br> 1 * 6 = 6<br> 1 * 7 = 7<br> 1 * 8 = 8<br>
				1 * 9 = 9<br>
			 -->	
			 <%=sb.toString()%>
			</h3>
		</div>
	</div>
	
	<form method="post" id="myForm">
		<input type="hidden" id="num" name="num" value="">
	</form>

</body>
</html>