
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

	<c:if test="${param.result == 'error'}">
	    <h1>로그인 에러</h1>
	</c:if>
	
	<form action="/login" method="post">
	    <input type="text" name="mid" value="user00"><br>
	    <input type="text" name="mpw" value="12345"><br>
	    <input type="checkbox" name="auto"><br>
	    <button type="submit">LOGIN</button>
	</form>
</body>
</html>
