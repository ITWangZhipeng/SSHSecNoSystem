<%--
  Created by IntelliJ IDEA.
  User: 10433208
  Date: 2016/12/9
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录</title>
</head>
<body>
<form action="UserServlet" method="get">
    用户名：
    <input type="text" name="username" />
    密码：
    <input type="password" name="password" />

    <input type="submit" value="submit" />
</form>


</body>
</html>
