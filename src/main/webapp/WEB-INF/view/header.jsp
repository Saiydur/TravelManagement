<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<header class="p-3 bg-dark text-white">
    <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 text-secondary">Home</a></li>
                    <li><a href="" class="nav-link px-2 text-secondary">About Us</a></li>
                    <li><a href="" class="nav-link px-2 text-secondary">Contact Us</a></li>
                </ul>
                <div class="text-end">
                    <a href="login" type="button" class="btn btn-outline-light me-2">Login</a>
                    <a href="register" type="button" class="btn btn-warning">Sign-up</a>
                </div>
            </div>
    </div>
</header>