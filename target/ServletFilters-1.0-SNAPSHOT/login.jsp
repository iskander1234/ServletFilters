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
    <title>Login</title>
</head>
<body>
<fildset>
    <legend>Login</legend>
    <form action="AccountController" method="post" >
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="checkbox" name="remember"> Remember Me ? </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form>
</fildset>
</body>
</html>
