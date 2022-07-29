<%--
  Created by IntelliJ IDEA.
  User: saiydur
  Date: 4/17/2022
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Buy Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header class="bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="" class="nav-link px-2 text-secondary">About Us</a></li>
                <li><a href="" class="nav-link px-2 text-secondary">Contact Us</a></li>
                <security:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
                    <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/admin/users">See All User</a></li>
                </security:authorize>
                <security:authorize access="hasRole('ROLE_TRAVEL_AGENT') and isAuthenticated()">
                    <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/user/addpackage">Add Package</a></li>
                    <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/user/show-user-packages?userId=${user.id}">View Package</a></li>
                </security:authorize>
                <security:authorize access="hasRole('ROLE_TRAVELLER') and isAuthenticated()">
                    <li><a class="nav-link px-2 text-secondary" href="${pageContext.request.contextPath}/user/show-packages">See Package</a></li>
                </security:authorize>
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
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Hurrah!</strong> <h1>You've Successfully Chosen This Package</h1>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <h3>Package Details</h3>
    <h2>${p.packageName}</h2>
    <h3>Package Description</h3>
    <h1>${p.description}</h1>
    <h3>Package Price</h3>
    <h1>${p.price}</h1>
    <h3>Tour Start Date</h3>
    <h1>${p.startDate}</h1>
    <h3>Tour End Date</h3>
    <h1>${p.endDate}</h1>
    <a class="btn btn-primary" href="<%--${pageContext.request.contextPath}/buy/confirm?packageId=${p.packageId}--%>">Pay Now</a>
    <a class="btn btn-info" href="<%--${pageContext.request.contextPath}/buy/paylater?packageId=${p.packageId}--%>">Pay Later</a>
    <button class="btn btn-dark">Print Receipt</button>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
