<%--
  Created by IntelliJ IDEA.
  User: TEST
  Date: 07.02.2020
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.hometask.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User-Info</title>
</head>
<body>

    <table width="100%" cellspacing="0" cellpadding="4">
    <c:forEach var="list" items="${user}">
        <tr>
            <td></td>
            <td>User-Info</td>
        </tr>
        <tr>
            <td align="right" width="100">ID:</td>
            <td>${list.id}</td>
        </tr>
        <tr>
            <td align="right" width="100">Email:</td>
            <td>${list.email}</td>
        </tr>
        <tr>
            <td align="right" width="100">Имя:</td>
            <td>${list.name}</td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td>${list.password}</td>
        </tr>
        <tr>
            <td align="right" width="150">Тип пользователя:</td>
            <td>${list.role}</td>
        </tr>

        </tr>
    </c:forEach>
    </table>
<form method="get" action="/logout">
    <input type="submit" value="Выход">
</form>
</body>
</html>
