<style><%@include file="css/style.css"%></style>

<nav class="navbar navbar-expand-lg bg-dark">
    <div class="container">
        <a class="navbar-brand linkStyle text-white" href="${pageContext.request.contextPath}/">Spring Jsp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.home}" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white" aria-current="page" href="https://github.com/circ93/java_microservices/" target="_blank">Git Gian</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white" aria-current="page" href="https://github.com/AlessandroS94/corso_21122022" target="_blank">Git Alessandro</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link linkStyle text-white ${param.feature}" aria-current="page" href="${pageContext.request.contextPath}/sites">Feature</a>
                </li>
            </ul>
        </div>

        <form class="d-flex" role="search">
            <input class="form-control me-2 float-end" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

    </div>
</nav>