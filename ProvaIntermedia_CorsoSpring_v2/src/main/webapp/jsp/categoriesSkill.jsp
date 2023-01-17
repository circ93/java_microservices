<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<body>
<header>
    <jsp:include page="script.jsp"></jsp:include>
    <jsp:include page="navbar.jsp">
        <jsp:param name="categories" value="active"/>
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
                    <th scope="col">Edit</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${categories}" var="cat">
                    <tr>
                        <td><c:out value="${cat.getName()}"/></td>
                        <td><c:out value="${cat.getDescription()}"/></td>
                        <td>
                            <a href="/adminPro/deleteCategory?id=${cat.getId()}"><i class="fa-solid fa-trash"></i></a>
                            <a href="/adminPro/searchCategory?id=${cat.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>


        </div>
        <!-- end column -->
    </div>
    <!-- end row -->


    <!-- row 2 -->
    <div class="row justify-content-center">
        <!-- column -->
        <div class="col-9 mt-3">

            <h1>New Category</h1>

            <form method="post" action="${pageContext.request.contextPath}/adminPro/createCategory">
                <div class="mb-3">
                    <label  class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" required="required">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Description</label>
                    <input type="text" class="form-control" name="description" required="required">
                </div>
                <button type="submit" class="btn btn-success">Save</button>
            </form>

            <p style="color: green;">${msg_insert}</p>


        </div>
        <!-- end column -->
    </div>
    <!-- end row 2-->


</div>
<!-- end container -->


</body>
</html>
