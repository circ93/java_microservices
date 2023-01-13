<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<body>
<header>
    <jsp:include page="script.jsp"></jsp:include>
    <jsp:include page="navbar.jsp"></jsp:include>
</header>

<!-- container -->
<div class="container">
    <!-- row -->
    <div class="row justify-content-center">
        <!-- column -->
        <div class="col-9 mt-3">

            <form method="post" action="${pageContext.request.contextPath}/updateInfo">
                <h3>MODIFICA INFO</h3>
                <div class="mb-3">
                    <label  class="form-label">ID utente</label>
                    <input type="number" class="form-control" name="id_2" disabled value="${info.getId()}">
                    <input type="hidden" class="form-control" name="id" value="${info.getId()}">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Nome</label>
                    <input type="text" class="form-control" name="name" required="required" value="${info.getName()}">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Description</label>
                    <input type="text" class="form-control" name="description" required="required" value="${info.getDescription()}" >
                </div>
                <button type="submit" class="btn btn-success">Update</button>
            </form>

        </div>
        <!-- end column -->
    </div>
    <!-- end row -->
</div>
<!-- end container -->


</body>
</html>
