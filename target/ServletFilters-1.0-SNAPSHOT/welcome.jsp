<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.02.2021
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
Welcome ${sessionScope.username}
<br>
<a href="AccountController?action=Logout">Logout</a>
</body>
</html>
