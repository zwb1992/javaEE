<%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/16
  Time: 上午9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="model.UserBean" scope="session"/>
<jsp:useBean id="userDao" class="model.UserDao" scope="page"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:setProperty name="user" property="*"/>
<%

   if(userDao.isLoginEd(user)){
       request.getRequestDispatcher("login_success.jsp").forward(request,response);
   }else {
       response.sendRedirect("login_failed.jsp");
   }
%>
