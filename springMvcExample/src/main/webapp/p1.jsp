<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2022/3/28
  Time: 上午8:26
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/p1" method="post">
    <table>
        <tr>
            <td>图书ID：</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>图书名称：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>出版社：</td>
            <td><input type="text" name="publisher"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>