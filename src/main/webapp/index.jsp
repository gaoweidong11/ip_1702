<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: 高伟冬
  Date: 2017/6/10
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ip查询</title>
</head>
<body>
<form action="index.jsp" method="post">
    <h1>IP SEARCH</h1>
    <input type="text" placeholder="请输入您要查询的IP地址">
    <input type="submit" value="查询">
</form>
<p>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
            out.println(message);
        }
    %>
</p>
</body>
</html>
