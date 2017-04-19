<%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/4/14
  Time: 下午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="testMethod" method="post">
    <input type="submit" value="submit">
</form>
<br>
<a href="test/hello">Test Hello</a>
<br>
<a href="helloworld">Hello World!</a>
<br>
<a href="testParamsAndHeader?name=zhangsan&&age=10">Test ParamsAndHeader</a>
<br>
<a href="testPathVariable/21">Test PathVariable</a>
<br>
<a href="testRest/21">Test REST GET</a>
<br>

<form action="testRest" method="post">
    <input type="submit" value="Test REST POST">
</form>
<br>
<form action="testRest/21" method="get">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Test REST DELETE">
</form>
<br>
<form action="testRest/21" method="get">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="Test REST PUT">
</form>
<br>

<a href="testRequestParam?username=zwb&age=10">Test RequestParam</a>
<br>
<a href="testCookieValue">testCookieValue</a>
<br>
<form action="testPojo" method="post">
    username:<input type="text" name="username"><br>
    password:<input type="text" name="password"><br>
    email:<input type="text" name="email"><br>
    street:<input type="text" name="address.street"><br>
    <input type="submit" value="submit">
</form>
<br>
<a href="testServletApi">testServletApi</a>
<br>
<a href="testModelAndView">testModelAndView</a>
<br>
<a href="testMap">testMap</a>
<br>
<!--
现在有这样一个需求：原始数据为 1，tom,123456,tom@qq.com
接收表单输入的值，要求密码不能被修改
-->
<form action="testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    username:<input type="text" name="username" value="tom"><br>
    email:<input type="text" name="email" value="tom@qq.com"><br>
    <input type="submit" value="testModelAttribute">
</form>
<br>
</body>
</html>
