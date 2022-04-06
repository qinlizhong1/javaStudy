<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/p4" method="post">
    图书 ID：<input type="text" name="id"/><br/>
    图书名称：<input type="text" name="name"/><br/>
    出版社：<input type="text" name="publisher"/><br/>
    Map类型-作者1名称：<input type="text" name="authorMap['a1'].name"/><br/>
    Map类型-作者1年龄：<input type="text" name="authorMap['a1'].age"/><br/>
    Map类型-作者2名称：<input type="text" name="authorMap['a2'].name"/><br/>
    Map类型-作者2年龄：<input type="text" name="authorMap['a2'].age"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>