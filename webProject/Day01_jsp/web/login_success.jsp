<%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/16
  Time: 上午9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.UserBean" %>

<html>
<head>
    <title>登录成功</title>
</head>
<body>
<jsp:useBean id="user" class="model.UserBean" scope="session"/>
<h1>登录成功，当前账户:<jsp:getProperty name="user" property="username"/>
</h1>
<%
    String name = "";
    if(session.getAttribute("user") != null){
        name = ((UserBean)session.getAttribute("user")).getUsername();
    }
%>
    <h1>登录成功，当前账户:<%=name%>
</h1>
</body>
</html>
