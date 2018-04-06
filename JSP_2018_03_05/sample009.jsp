<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	//JSP code
	//배열 요소 정렬

	//정렬 : 요소를 크기순으로 나열하는 행위. 오름차순, 내림차순
	//정렬 알고리즘(Bubble-두 인접한 원소를 검사하여 정렬하는 방법)을 적용한 정렬

	/*
	1. 배열 요소에 정렬되지 않은 기본자료형 요소 준비 -> 5개
	2. 두 인접한 요소 비교
	3. (오름차순인 경우)왼쪽 요소가 크고, 오른쪽 요소가 작은 경우 교환. 그렇지 않은 경우 통과.
	4. 비교와 교환 액션을 배열 요소 전체에 대해서 적용할 때까지 반복. 0-1, 1-2, 2-3, 3-4, ...
	5. 배열 요소 전체에 대한 비교, 교환 액션 한 번 진행한 상태를 1회전.
	6. 배열 요소 중에서 가장 큰 값이 가장 오른쪽에 위치한다.
	7. 2번~6번 과정을 반복. 단, 정렬이 끝난 요소는 제외.
	8. 비교 대상이 없어지면 반복 종료.
	*/

	StringBuilder sb = new StringBuilder();
	int[] arr = { 3, 5, 4, 2, 1 };

	//정렬 전 출력
	sb.append("정렬 전 : ");
	sb.append(java.util.Arrays.toString(arr));
	sb.append("<br>");

	//정렬 과정

	//아래 액션을 여러번 반복. 단, 정렬이 끝난 요소는 제외.
	//n은 0, 1, 2, 3, ..., 마지막값(배열요소의 갯수 - 2)으로 진행하기 위해서 반복문 사용
	//비교 및 교환(치환) 액션
	/*
	if (arr[n] > arr[n+1]) {
		int temp = arr[n+1];
		arr[n+1] = arr[n];
		arr[n] = temp;
	}
	*/
	for (int m = 1; m < arr.length; ++m) {
		for (int n = 0; n < arr.length - m; ++n) {
			if (arr[n] > arr[n + 1]) {
				int temp = arr[n + 1];
				arr[n + 1] = arr[n];
				arr[n] = temp;
			}
		}
	}

	//정렬 후 출력
	sb.append("정렬 후 : ");
	sb.append(java.util.Arrays.toString(arr));
	sb.append("<br>");
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
		<h1>Bubble Sort</h1>
		<ol>
			<li>배열 요소에 정렬되지 않은 기본자료형 요소 준비</li>
			<li>두 인접한 요소 비교</li>
			<li>(오름차순인 경우)왼쪽 요소가 크고, 오른쪽 요소가 작은 경우 교환. 그렇지 않은 경우 통과.</li>
			<li>비교와 교환 액션을 배열 요소 전체에 대해서 적용할 때까지 반복. 0-1, 1-2, 2-3, 3-4, ...</li>
			<li>배열 요소 전체에 대한 비교, 교환 액션 한 번 진행한 상태를 1회전.</li>
			<li>배열 요소 중에서 가장 큰 값이 가장 오른쪽에 위치한다.</li>
			<li>2번~6번 과정을 반복. 단, 정렬이 끝난 요소는 제외.</li>
			<li>비교 대상이 없어지면 반복 종료.</li>
		</ol>
		<p><%=sb.toString()%></p>
	</div>

</body>
</html>