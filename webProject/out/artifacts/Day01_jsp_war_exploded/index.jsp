<%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/8
  Time: 下午5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
Hello world
第一个项目运行成功！
<%
    out.println("在jsp中调用方法打印出来的");
%>

<%!
    String s = "在jsp中自定义的变量";
%>

s=<%=s%>
<%-- 隐式注释--%>
<!-- 显示注释-->
<%
    //隐式注释
  /*
  隐式注释
  */
%>
<br>
<h1>99乘法表--jsp表达式</h1>
<%!
    public String method1() {
        String s = "";
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                s += i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;";
            }
            s += "<br>";
        }
        return s;
    }
%>
<%
    out.println(method1());
%>
<br>
<h1>99乘法表--jsp脚本</h1>
<%
    String result = "";
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
            result += i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        out.println(result+"<br>");
        result = "";
    }
%>
<form method="get" name="form" action="one">
    <input name="username" type="text">
    <input type="submit" value="submit">
</form>
</body>
</html>
