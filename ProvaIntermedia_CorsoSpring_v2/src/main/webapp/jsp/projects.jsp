<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<body>
<header>
    <jsp:include page="script.jsp"></jsp:include>
    <jsp:include page="navbar.jsp">
        <jsp:param name="projects" value="active"/>
    </jsp:include>
</header>

<!-- container -->
<div class="container">
    <!-- row -->
    <div class="row justify-content-center">
        <!-- column -->
        <div class="col-9 mt-3">

            <h1>Projects</h1>

            <p style="color: green;">${msg_delete}</p>
            <p style="color: green;">${msg_update}</p>
            <p style="color: red;">${msg_error}</p>


            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Repository</th>
                    <th scope="col">Edit</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${projects}" var="project">
                    <tr>
                        <td><c:out value="${project.getName()}"/></td>
                        <td><c:out value="${project.getDescription()}"/></td>
                        <td><c:out value="${project.getRepo()}"/></td>
                        <td>
                            <a href="/deleteProject?id=${project.getId()}"><i class="fa-solid fa-trash"></i></a>
                            <a href="/searchProject?id=${project.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>


        </div>
        <!-- end column -->
    </div>
    <!-- end row -->
</div>
<!-- end container -->


</body>
</html>
