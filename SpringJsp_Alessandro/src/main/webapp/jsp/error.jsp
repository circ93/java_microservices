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
<h1 style="color: red;">Page Error Custom</h1>

${Error}
<br>
${Error_msg}


</body>
</html>
