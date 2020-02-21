<%--
  Created by IntelliJ IDEA.
  User: TEST
  Date: 17.02.2020
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<form class="your-form-selector" method="post" action="/admin/add">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td></td>
            <td>Добавление пользователя:</td>
        </tr>
        <tr>
            <td align="right" width="100">Имя:</td>
            <td><input type="text" name="username" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td><input type="password" name="password" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="150">Тип пользователя:</td>
            <td><input type="checkbox" name="role1" value="1">USER<Br>
                <input type="checkbox" name="role2" value="2">ADMIN<Br>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Добавить пользователя"></td>
        </tr>
    </table>
</form>
<table border="" width="600" cellspacing="1" cellpadding="4">
    <caption>Списо пользователей:</caption>
    <tr>
        <td align="center">ID</td>
        <td align="center">Имя</td>
        <td align="center">Пароль</td>
        <td align="center">Тип пользователя</td>
        <td align="center">Удалить/Изменить</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td align="center">${user.id}</td>
            <td align="center">${user.username}</td>
            <td align="center">${user.password}</td>
            <td align="center"><c:forEach items="${user.roles}" var="role">${role.toString()}<br/></c:forEach></td>
            <td align="center">
                <form method="post" action="/admin/delete">
                    <input type="hidden" name="id" value=${user.id}>
                    <input type="submit" value="Delete">
                </form>
                <form method="post" action="/admin/edit">
                    <input type="hidden" name="id" value=${user.id}>
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>


</table>
<jsp:include page="user-logout.jsp"/>
</body>
</html>
