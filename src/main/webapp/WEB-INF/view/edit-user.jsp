<%--
  Created by IntelliJ IDEA.
  User: saiydur
  Date: 4/18/2022
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Update User</h1>
    <form:form action="${pageContext.request.contextPath}/admin/users/update-edit" method="post" modelAttribute="user">
        <form:hidden path="id" />
        <form:label path="username">Username:</form:label>
        <form:input path="username" label="Username" /> <form:errors path="username" />

        <form:label path="usersDetailsModel.firstName">First Name:</form:label>
        <form:input path="usersDetailsModel.firstName" label="First Name" /> <form:errors path="usersDetailsModel.firstName" />

        <form:label path="usersDetailsModel.lastName">Last Name:</form:label>
        <form:input path="usersDetailsModel.lastName" label="Last Name" /> <form:errors path="usersDetailsModel.lastName" />

        <form:label path="usersDetailsModel.email">Email:</form:label>
        <form:input path="usersDetailsModel.email" label="Email" /> <form:errors path="usersDetailsModel.email" />

        <form:label path="usersDetailsModel.phoneNumber">Phone:</form:label>
        <form:input path="usersDetailsModel.phoneNumber" label="Phone" /> <form:errors path="usersDetailsModel.phoneNumber" />

        <form:label path="usersDetailsModel.address">Address:</form:label>
        <form:input path="usersDetailsModel.address" label="Address" /> <form:errors path="usersDetailsModel.address" />

        <form:hidden path="enable" />
        <form:hidden path="role" />
        <form:hidden path="password" />


        <form:button type="submit">Update</form:button>
    </form:form>
</body>
</html>
