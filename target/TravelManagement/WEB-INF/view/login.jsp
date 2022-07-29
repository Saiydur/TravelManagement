<%--
  Created by IntelliJ IDEA.
  User: saiydur
  Date: 4/14/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <form:form method="post" action="${pageContext.request.contextPath}/login" cssClass="form g-3">
            <div class="form-group m-4">
                <label for="username">Username</label>
                <input id="username" class="form-control" name="username" placeholder="Username"/>
            </div>
            <div class="form-group m-4">
                <label for="password">Password</label>
                <input id="password" class="form-control" name="password" placeholder="Password"/>
            </div>
            <div class="form-group m-4">
                <button class="btn btn-primary w-100 p-3" type="submit">Login</button>
            </div>
        </form:form>
    </div>
</body>
</html>
