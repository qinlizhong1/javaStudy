<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2022/3/27
  Time: 下午6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form method="post" action="/JavaWebExample_war_exploded/login">
        <input type="text" name="username" value="admin"> <br/>
        <input type="password" name="password" value="123456"> <br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
