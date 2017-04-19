<%@ page import="java.util.List" %>
<%@ page import="com.spring.Good" %>
<%@ page import="db.GoodsDao" %><%--
  Created by IntelliJ IDEA.
  User: zwb
  Date: 17/3/20
  Time: 上午11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
    <style type="text/css">
        div {
            float: left;
            margin: 10px;
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
<%
    List<Good> goods = new GoodsDao().getGoods();
%>
<center>
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="650" height="60">
        <tr>
            <td>
                <%
                    for (Good good : goods) {
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=good.getId()%>"><img src="images/<%=good.getPhoto()%>" width="120" height="90"></a>
                        </dt>
                        <dd class="dd_name"><%=good.getName()%></dd>
                        <dd class="dd_city">产地:<%=good.getAddress() %>&nbsp;&nbsp;&nbsp;&nbsp;价格:<%=good.getPrice()%></dd>
                    </dl>
                </div>
                <%
                    }
                %>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
