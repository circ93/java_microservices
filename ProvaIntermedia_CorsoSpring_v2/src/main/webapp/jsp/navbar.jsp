<style><%@include file="css/nav.css"%></style>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg bg-dark">
    <div class="container">
        <a class="navbar-brand linkStyle text-white" href="${pageContext.request.contextPath}/">Prova Spring</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.home}" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.projects}" aria-current="page" href="${pageContext.request.contextPath}/projects">Projects</a>
                </li>
                <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.newProjects}" aria-current="page" href="${pageContext.request.contextPath}/admin/newProject">New Projects</a>
                </li>
                </sec:authorize>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.skills}" aria-current="page" href="${pageContext.request.contextPath}/skills">Skills</a>
                </li>
                <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.newSkills}" aria-current="page" href="${pageContext.request.contextPath}/admin/newSkills">New Skills</a>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.categories}" aria-current="page" href="${pageContext.request.contextPath}/admin/categories">Categories</a>
                </li>
                </sec:authorize>

            </ul>
        </div>
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <sec:authorize access="isAuthenticated()">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/logout">Logout</a>
            </li>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/login">Login</a>
            </li>
        </sec:authorize>
        </ul>
        <form class="d-flex search" role="search">
            <input class="form-control me-2 float-end" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

    </div>
</nav>