<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${path}/socket/login" method="post">
    登录名：<input type="text" name="username"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>