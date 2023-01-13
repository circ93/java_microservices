<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<body>
<header>
    <jsp:include page="script.jsp"></jsp:include>
    <jsp:include page="navbar.jsp">
        <jsp:param name="createInfo" value="active"/>
    </jsp:include>
</header>

<!-- container -->
<div class="container">
    <!-- row -->
    <div class="row justify-content-center">
        <!-- column -->
        <div class="col-9 mt-3">

            <h1>Sites</h1>

            <form method="post" action="${pageContext.request.contextPath}/createInfo">
                <h3>INSERISCI INFO</h3>
                <div class="mb-3">
                    <label  class="form-label">Name Site</label>
                    <input type="text" class="form-control" name="name" required="required">
                </div>
                <div class="mb-3">
                    <label  class="form-label">Description Site</label>
                    <input type="text" class="form-control" name="description" required="required">
                </div>
                <button type="submit" class="btn btn-success">Save</button>
            </form>

            <p style="color: green;">${msg_insert}</p>



        </div>
        <!-- end column -->
    </div>
    <!-- end row -->
</div>
<!-- end container -->


</body>
</html>
