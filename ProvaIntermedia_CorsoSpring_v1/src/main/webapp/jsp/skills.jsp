<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<body>
<header>
    <jsp:include page="script.jsp"></jsp:include>
    <jsp:include page="navbar.jsp">
        <jsp:param name="skills" value="active"/>
    </jsp:include>
</header>

<!-- container -->
<div class="container">
    <!-- row -->
    <div class="row justify-content-center">
        <!-- column -->
        <div class="col-9 mt-3">

            <h1>Skills</h1>

            <p style="color: green;">${msg_delete}</p>
            <p style="color: green;">${msg_update}</p>
            <p style="color: red;">${msg_error}</p>


            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Category</th>
                    <th scope="col">Edit</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${skills}" var="skill">
                    <tr>
                        <td><c:out value="${skill.getName()}"/></td>
                        <td><c:out value="${skill.getDescription()}"/></td>
                        <td><c:out value="${skill.getCategory()}"/></td>
                        <td>
                            <a href="/deleteSkill?id=${skill.getId()}"><i class="fa-solid fa-trash"></i></a>
                            <a href="/searchSkill?id=${skill.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
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
