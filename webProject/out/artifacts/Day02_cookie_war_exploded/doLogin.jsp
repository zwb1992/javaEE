<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/16
  Time: 下午10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理登录信息</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="bean.User" scope="page"/>
<jsp:setProperty name="user" property="*"/>
<%
    String[] records = request.getParameterValues("record");
    if(records != null && records.length>0){
        Cookie nameCookie = new Cookie("name", URLEncoder.encode(user.getUserName(),"UTF-8"));
        nameCookie.setMaxAge(864000);//设置cookie过期时间为10天
        Cookie passCookie = new Cookie("pass",URLEncoder.encode(user.getPassWord(),"UTF-8"));
        passCookie.setMaxAge(864000);
        response.addCookie(nameCookie);
        response.addCookie(passCookie);
    }else {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("name".equals(cookie.getName()) ||"pass".equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);//必须加上这一句，否则无法生效
                }
            }
        }
    }
%>
<h1>登录成功！<%=user.getUserName()%></h1>
<br>
<a href="login_success.jsp">查看用户信息</a>
</body>
</html>
