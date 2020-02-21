<%--
  Created by IntelliJ IDEA.
  User: TEST
  Date: 17.02.2020
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование пользователя</title>
</head>
<body>
<form class="your-form-selector" method="post" action="/admin/update">
    <table width="100%" cellspacing="0" cellpadding="4">
        <c:forEach var="user" items="${list}">
            <tr>
                <td></td>
                <td>Редактирование пользователя:</td>
            </tr>
            <tr>
                <td align="right" width="100">ID:</td>
                <td><p>${user.id}</p></td>
                <td><input type="hidden" name="id" value=${user.id} maxlength="50" size="20"></td>
            </tr>
            <tr>
                <td align="right" width="100">Имя:</td>
                <td><input type="text" name="username" value=${user.username} maxlength="50" size="20" required placeholder></td>
            </tr>
            <tr>
                <td align="right" width="100">Пароль:</td>
                <td><input type="text" name="password" value=${user.password} maxlength="50" size="20" required placeholder></td>
            </tr>
            <tr>
                <td align="right" width="150">Роли пользователя:</td>
                <td> <c:forEach items="${user.roles}" var="role">${role.toString()}<br/></c:forEach></td>
            </tr>
            <tr>
                <td align="right" width="150">Тип пользователя:</td>
                <td><input type="checkbox" name="role1" value="1">USER<Br>
                    <input type="checkbox" name="role2" value="2">ADMIN<Br>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Подтвердить изменения"></td>
            </tr>
            </tr>
        </c:forEach>
    </table>
</form>
<jsp:include page="user-logout.jsp"/>
</body>
</html>
