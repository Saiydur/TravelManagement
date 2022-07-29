<%--
  Created by IntelliJ IDEA.
  User: saiydur
  Date: 4/13/2022
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.travelmanagement.utils.Roles" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <form:form cssClass="row g-3" action="${pageContext.request.contextPath}/process-register" method="post" modelAttribute="user" autocomplete="false" >
        <div class="col-12">
            <form:label path="username" cssClass="form-label">User Name</form:label>
            <form:input path="username" cssClass="form-control"/><form:errors path="username" />
        </div>
        <div class="col-12">
            <form:label path="password" cssClass="form-label">Password</form:label>
            <form:password path="password" cssClass="form-control"/><form:errors path="password" />
        </div>
        <div class="col-6">
            <form:label path="usersDetailsModel.firstName" cssClass="form-label">First Name</form:label>
            <form:input path="usersDetailsModel.firstName" cssClass="form-control"/><form:errors path="usersDetailsModel.firstName" />
        </div>
        <div class="col-6">
            <form:label path="usersDetailsModel.lastName" cssClass="form-label">Last Name</form:label>
            <form:input path="usersDetailsModel.lastName" cssClass="form-control"/><form:errors path="usersDetailsModel.lastName" />
        </div>
        <div class="col-12">
            <form:label path="usersDetailsModel.email" cssClass="form-label">Email</form:label>
            <form:input path="usersDetailsModel.email" cssClass="form-control"/><form:errors path="usersDetailsModel.email" />
        </div>
        <div class="col-6">
            <form:label path="usersDetailsModel.phoneNumber" cssClass="form-label">Phone Number</form:label>
            <form:input path="usersDetailsModel.phoneNumber" cssClass="form-control"/><form:errors path="usersDetailsModel.phoneNumber" />
        </div>
        <div class="col-6">
            <form:label path="role" cssClass="form-label">Role</form:label>
            <form:select path="role" cssClass="form-control">
                <option value="<%=Roles.ROLE_TRAVEL_AGENT%>">Travel Agent</option>
                <option value="<%=Roles.ROLE_TRAVELLER%>">Traveller</option>
            </form:select>
        </div>

        <div class="col-12">
            <form:label path="usersDetailsModel.address" cssClass="form-label">Address</form:label>
            <form:input path="usersDetailsModel.address" cssClass="form-control"/><form:errors path="usersDetailsModel.address" />
        </div>

        <form:button type="submit" class="btn btn-success p-4">Register</form:button>
    </form:form>
</div>
</body>
</html>
