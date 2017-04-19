<%@ page import="com.spring.Good" %>
<%@ page import="db.GoodsDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/21
  Time: 下午12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <style type="text/css">
        div {
            float: left;
            margin-left: 30px;
            margin-right: 30px;
            margin-top: 5px;
            margin-bottom: 5px;
        }

        div dd {
            margin: 0px;
            font-size: 10pt;
        }

        div dd.dd_name {
            color: blue;
        }

        div dd.dd_city {
            color: #000;
        }
    </style>
</head>
<body>
<h1>商品详情</h1>
<hr>
<center>
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="650" height="60">
        <tr>
            <%
                int id = Integer.parseInt(request.getParameter("id"));
                Good item = new GoodsDao().getGoodById(id);
                if (item != null) {
            %>
            <td width="70%" valign="top">
                <table>
                    <tr>
                        <td rowspan="4"><img src="images/<%=item.getPhoto()%>" width="200" height="160"/></td>
                    </tr>
                    <tr>
                        <td><B><%=item.getName() %>
                        </B></td>
                    </tr>
                    <tr>
                        <td>产地：<%=item.getAddress()%>
                        </td>
                    </tr>
                    <tr>
                        <td>价格：<%=item.getPrice() %>￥</td>
                    </tr>
                </table>
            </td>
            <%
                }
            %>
            <%
                String list = "";
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length > 0) {
                    for (Cookie cookie : cookies) {
                        if ("selection".equals(cookie.getName())) {
                            list = cookie.getValue();
                        }
                    }
                }
                list += request.getParameter("id") + "_";
                //如果浏览记录超过1000条，清零.
                String[] arr = list.split("_");
                if (arr != null && arr.length >= 1000) {
                    list = "";
                }
                Cookie cookie = new Cookie("selection", list);
                response.addCookie(cookie);
            %>
            <!-- 浏览过的商品 -->
            <td width="30%" bgcolor="#EEE" align="center">
                <br>
                <b>您浏览过的商品</b><br>
                <!-- 循环开始 -->
                <%
                    List<Good> itemlist = new GoodsDao().getGoodsBySelected(list);
                    if (itemlist != null && itemlist.size() > 0) {
                        for (Good i : itemlist) {
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPhoto() %>" width="120"
                                                                         height="90" border="1"/></a>
                        </dt>
                        <dd class="dd_name"><%=i.getName() %>
                        </dd>
                        <dd class="dd_city">产地:<%=i.getAddress() %>&nbsp;&nbsp;价格:<%=i.getPrice() %> ￥</dd>
                    </dl>
                </div>
                <%
                        }
                    }
                %>
                <!-- 循环结束 -->
            </td>
        </tr>
    </table>
</center>
</body>
</html>
