<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head><title>로그인</title></head>
<body>
<form action="${pageContext.request.contextPath}/login/login">
아이디<input type="text" name="id">
암호<input type="password" name="pw">
<input type="submit" value="로그인">
</form>
</body>
</html>