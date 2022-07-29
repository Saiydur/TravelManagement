<%--
  Created by IntelliJ IDEA.
  User: saiydur
  Date: 4/16/2022
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Packages</title>
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
        <table class="table">
            <tbody class="text-center align-center">
            <tr>
                <th>Package Name</th>
                <th>Package Price</th>
                <th>Package Description</th>
                <th colspan="2">Action</th>
            </tr>
            <c:choose>
                <c:when test="${!empty all_packages}">
                    <c:forEach items="${all_packages}" var="p">
                        <c:url var="see_package" value="/user/see-package">
                            <c:param name="packageId" value="${p.id}"/>
                        </c:url>
                        <c:url var="buy_package" value="/user/buy-package">
                            <c:param name="packageId" value="${p.id}"/>
                        </c:url>
                        <c:url var="delete_package" value="/user/package-delete">
                            <c:param name="packageId" value="${p.id}"/>
                        </c:url>
                        <c:url var="edit_package" value="/user/package-edit">
                            <c:param name="packageId" value="${p.id}"/>
                        </c:url>
                        <tr>
                            <td>${p.packageName}</td>
                            <td>${p.price}</td>
                            <td>${p.description}</td>
                            <c:choose>
                                <c:when test='${ROLE=="ROLE_TRAVEL_AGENT"}'>
                                    <td><a class="btn btn-danger" href="${delete_package}">Delete</a></td>
                                    <td><a class="btn btn-success" href="${edit_package}">Edit</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a class="btn btn-success" href="${see_package}">See Package</a></td>
                                    <td><a class="btn btn-success" href="${buy_package}">Buy Package</a></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="4">No Packages</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</body>
</html>
