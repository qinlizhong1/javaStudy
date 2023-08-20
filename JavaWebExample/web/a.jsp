<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="test2.User" %><%--
  Created by IntelliJ IDEA.
  User: Ziph
  Date: 2020/4/27
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取域数据</title>
</head>
<body>
<%--数组--%>
<%
    String[] username = {"Ziph", "Join", "Marry", "Jack"};
    pageContext.setAttribute("username", username);
%>
<%--JSP输出脚本取出数组中下标0的username值--%>
<%--步骤：取数组中的域数据、强转为字符串数组、取出下标为0的域数据--%>
<%=
((String[]) pageContext.getAttribute("username"))[0]
%>
${username[0]}

<%--List集合--%>
<%
    List<String> fruits = new ArrayList<>();
    fruits.add("苹果");
    fruits.add("香蕉");
    fruits.add("橘子");
    request.setAttribute("fruitsName", fruits);
%>
<%--取出List的集合中的第一个数据--%>
<%=
((List<String>) request.getAttribute("fruitsName")).get(0)
%>
<%--两种方法都可以，相同作用--%>
${fruitsName.get(0)}
${fruitsName[0]}

<%--Map集合--%>
<%
    Map<String, String> vegetables = new HashMap<>();
    vegetables.put("tomato", "西红柿");
    vegetables.put("cucumber", "黄瓜");
    vegetables.put("lettuce", "莴笋");
    session.setAttribute("vegetablesName", vegetables);
%>
<%--取出Map集合中的西红柿--%>
<%=
((Map<String, String>) session.getAttribute("vegetablesName")).get("tomato")
%>
${vegetablesName.tomato}

<%--Java对象--%>
<%
    User user = new User(1, "Ziph", "123456");
    application.setAttribute("user", user);
%>
<%--获取User对象的用户名--%>
<%=
((User) application.getAttribute("user")).getUsername()
%>
${user.username}
</body>
</html>
