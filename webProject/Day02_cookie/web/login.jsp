<%@ page import="java.net.*" %><%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/16
  Time: 下午10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String name = "";
    String pass = "";
    Cookie cookies[] = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            if ("name".equals(cookie.getName())) {
                name = URLDecoder.decode(cookie.getValue(), "UTF-8");
            }
            if ("pass".equals(cookie.getName())) {
                pass = URLDecoder.decode(cookie.getValue(), "UTF-8");
            }
        }
    }
%>

<form name="login" method="post" action="doLogin.jsp">
    <input name="userName" type="text" value="<%=name%>"><br>
    <input name="passWord" type="text" value="<%=pass%>"><br>
    <input name="record" type="checkbox" value="10天内记住我的登录状态" checked="true">10天内记住我的登录状态<br>
    <input type="submit" value="登录">
</form>
</body>
</html>
