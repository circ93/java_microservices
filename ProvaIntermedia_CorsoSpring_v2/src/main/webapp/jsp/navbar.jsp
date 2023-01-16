<style><%@include file="css/nav.css"%></style>

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
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.newProjects}" aria-current="page" href="${pageContext.request.contextPath}/newProject">New Projects</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.skills}" aria-current="page" href="${pageContext.request.contextPath}/skills">Skills</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.newSkills}" aria-current="page" href="${pageContext.request.contextPath}/newSkills">New Skills</a>
                </li>
            </ul>
        </div>

        <form class="d-flex" role="search">
            <input class="form-control me-2 float-end" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

    </div>
</nav>