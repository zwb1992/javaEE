<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/16
  Time: 下午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
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
用户名:<%=name%>
密码:<%=pass%>
</body>
</html>
