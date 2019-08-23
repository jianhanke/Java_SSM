<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/registerUser" method="post">
		用户名: <input type="text" name="username" /> <br />
		密码 : <input type="password" name="password" /> <br />
		<input type="submit" value="注册" />
		${pageContext.request.contextPath }
	</form>
	
</body>
</html>