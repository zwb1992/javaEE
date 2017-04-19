<%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/22
  Time: 上午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!-- 使用相对目录进行请求-->
  <a href="pathServlet">跳转进入servlet，使用相对目录进行请求</a>
  <hr>
  <!-- /代表的是项目的根目录 -->
  <a href="/pathServlet">跳转进入servlet，路径（/pathServlet）</a>
  <hr>
  <!-- 使用绝对目录进行请求 -->
  <a href="<%=request.getContextPath()%>/pathServlet">跳转进入servlet，使用绝对目录进行请求</a>
  </body>
</html>
