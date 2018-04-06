<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//JSP code
	StringBuilder sb = new StringBuilder();

	//GET 방식 요청 자료를 수신하는 과정
	String pageNum =  request.getParameter("pageNum");

	//주의) 최초 실행시 pageNum은 null이 채워진다. 초기값 지정 액션 추가.
	if (pageNum == null) {
		pageNum = "1";
	}
	
	if (pageNum.equals("1")) {
		sb.append(String.format("<tr><td>Project</td><td>2018.03~2018.05</td><td>july@example.com</td></tr>"));		
	} else if (pageNum.equals("2")) {
		sb.append(String.format("<tr><td>JDBC</td><td>2018.02~2018.03</td><td>july@example.com</td></tr>"));		
	} else if (pageNum.equals("3")) {
		sb.append(String.format("<tr><td>Oracle</td><td>2018.02~2018.02</td><td>july@example.com</td></tr>"));		
	} else if (pageNum.equals("4")) {
		sb.append(String.format("<tr><td>Java SE</td><td>2018.01~2018.02</td><td>july@example.com</td></tr>"));		
	}
	
	//이전, 다음 페이지 번호를 얻는 과정 추가
	//이전 -> 현재 페이지 - 1
	//다음 -> 현재 페이지 + 1
	String prePage = String.valueOf(Integer.parseInt(pageNum) - 1);
	String nextPage = String.valueOf(Integer.parseInt(pageNum) + 1); 

	//문제) 활성, 비활성 상태를 결정하는 과정 추가. 페이지 범위는 1 ~ 4라고 가정한다.
	//Previous -> 비활성, Next -> 활성
	//Previous -> 활성, Next -> 활성
	//Previous -> 활성, Next -> 비활성
	//Previous -> 비활성, Next -> 비활성
	String preDisabled = "";
	String nextDisabled = "";
	if (pageNum.equals("1")) {
		preDisabled = "disabled";
	} 
	if (pageNum.equals("4")) {
		nextDisabled = "disabled";
	}
	
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

		// jQuery methods go here...
		

	});
</script>
</head>
<body>

	<div class="container">
	
		<h1>Query String을 이용한 페이징</h1>

		<h3>홍길동 강사 강의 일정</h3>

		<div>
			<table class="table">
				<thead>
					<tr>
						<th>과목명</th>
						<th>기간</th>
						<th>강사</th>
					</tr>
				</thead>
				<tbody>
					<%=sb.toString()%>
				</tbody>
			</table>
		</div>

		<ul class="pager">
			<!-- GET 방식 요청 -->
			<!-- 요청 URL 끝 부분에 쿼리 문자열 지정함으로써 페이지 요청에 필요한 정보 전송 -->
			<!-- URL?key=value&key=value&key=value -->
			<!-- 주의) 페이지 번호가 범위를 벗어나는 경우 비활성 처리 필요 -->
			<!-- 주의) GET 방식 요청시 영문, 숫자는 안전하게 전송 가능하지만, 단, 특수문자, 공백, 한글 포함시 인코딩 처리 필요 또는 POST 방식 전송. --> 
			<li><button
					onclick="location.assign('sample026.jsp?pageNum=<%=prePage%>')"
					type="button" class="btn btn-default"  <%=preDisabled%> >Previous</button></li>
			<li><button
					onclick="location.assign('sample026.jsp?pageNum=<%=nextPage%>')"
					type="button" class="btn btn-default"  <%=nextDisabled%> >Next</button></li>
		</ul>
		
	</div>

</body>
</html>