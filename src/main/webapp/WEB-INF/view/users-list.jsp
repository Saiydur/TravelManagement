<%--
  Created by IntelliJ IDEA.
  User: saiydur
  Date: 4/18/2022
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Users List</h1>
<table>
    <tr>
        <th>Id</th>
        <th>User Name</th>
        <th>Role</th>
        <th>Is Enable</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.role}</td>
            <td>${user.enable}</td>
            <td>${user.usersDetailsModel.firstName}</td>
            <td>${user.usersDetailsModel.lastName}</td>
            <td>${user.usersDetailsModel.email}</td>
            <td>${user.usersDetailsModel.phoneNumber}</td>
            <td>${user.usersDetailsModel.address}</td>
            <td colspan="2">

                <a href="${pageContext.request.contextPath}/admin/users/edit?id=${user.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/admin/users/delete?id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
