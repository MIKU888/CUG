<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/22 0022
  Time: 下午 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>管理员登陆</title>
    <link href="css/Adminlogin.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/HouseWeb/AdminLoginServlet" method="post" id="form">
        <h1 id="loginMsg">ADMIN LOGIN IN</h1>
        <div id="errorMsg">${login_msg}</div>
        <p>Username:<input id="username" name="username" type="text"></p>

        <p>Password:<input id="password" name="password" type="password"></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
        </div>
        <div id="admin">
            <a href="login.jsp">我不是管理员</a>
        </div>
    </form>
</div>

</body>
</html>
