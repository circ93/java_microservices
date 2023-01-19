<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<body>
<header>
    <jsp:include page="script.jsp"></jsp:include>
    <jsp:include page="navbar.jsp">
        <jsp:param name="error" value="active"/>
    </jsp:include>
</header>
<!-- container -->
<div class="container">
    <!-- row -->
    <div class="row justify-content-center">
        <!-- column -->
        <div class="col-9 mt-3">

            <h1 style="color: red;">Page Error Custom</h1>

            ${Error}
            <br>
            ${Error_msg}


        </div>
        <!-- end column -->
    </div>
    <!-- end row -->
</div>
<!-- end container -->


</body>
</html>
