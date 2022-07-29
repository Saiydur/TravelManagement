<%--
  Created by IntelliJ IDEA.
  User: saiydur
  Date: 4/16/2022
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

    <header class="bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="" class="nav-link px-2 text-secondary">About Us</a></li>
                    <li><a href="" class="nav-link px-2 text-secondary">Contact Us</a></li>

                    <c:choose>
                        <c:when test="${user.role == 'ROLE_ADMIN'}">
                            <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/admin/users">See All User</a></li>
                        </c:when>
                        <c:when test="${user.role=='ROLE_TRAVEL_AGENT'}">
                            <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/user/addpackage">Add Package</a></li>
                            <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/user/show-user-packages?userId=${user.id}">View Package</a></li>
                        </c:when>
                        <c:when test="${user.role=='ROLE_TRAVELLER'}">
                            <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/user/show-packages">See Package</a></li>
                        </c:when>
                    </c:choose>
                </ul>
                <div class="text-end">
                    <a href="${pageContext.request.contextPath}/user/dashboard" class="btn btn-outline-warning mt-2">Profile</a>
                    <c:url var="logoutUrl" value="/logout"/>
                    <form action="${logoutUrl}"
                          method="post">
                        <input class="btn btn-outline-light mt-2" type="submit"
                               value="Log out" />
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <div class="text-start">
            <button class="btn btn-outline-warning px-4 mt-2">Edit</button>
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-12">
                <div class="col-md-6">
                    <h1>First Name : ${user.usersDetailsModel.firstName}</h1>
                </div>
                <div class="col-md-6">
                    <h1>Last Name : ${user.usersDetailsModel.lastName}</h1>
                </div>
                <div class="col-md-12">
                    <h1>Email : ${user.usersDetailsModel.email}</h1>
                </div>
                <div class="col-md-6">
                    <h1>Phone Number : ${user.usersDetailsModel.phoneNumber}</h1>
                </div>
                <div class="col-md-6">
                    <h1>User Name : ${user.username}</h1>
                </div>
                <div class="col-md-6">
                    <h1>Address : ${user.usersDetailsModel.address}</h1>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
