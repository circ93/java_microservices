<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style><%@include file="css/style.css"%></style>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>

<body>
<header>
    <jsp:include page="script.jsp"></jsp:include>
    <jsp:include page="navbar.jsp">
        <jsp:param name="home" value="active"/>
    </jsp:include>
</header>

<!-- container -->
<div class="container container_home">
    <!-- row 1 -->
    <div class="row justify-content-center">
        <!-- column -->
        <div class="col-9 mt-3 text-center">

            <h1 class="mt-3 mb-3">My Personal Page</h1>
            <img class="img_home" src="https://static.vecteezy.com/system/resources/previews/003/335/579/large_2x/desktop-source-code-and-wallpaper-by-coding-and-programming-free-photo.jpg"
                 alt="img_code" height="400px">

        </div>
        <!-- end column -->
    </div>
    <!-- end row 1 -->
    
    <!-- row 2 -->
    <div class="row mt-3 justify-content-center">
        <!-- column 1 -->
        <div class="col-6 px-1">
            <h3>Gianluca Circelli</h3>
            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer
                took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,
                but also the leap into electronic typesetting, remaining essentially unchanged.
                It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
                and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        </div>
        <!-- end column 1 -->
        
        <!-- column 2 -->
        <div class="col-3 px-3 text-center">
            <!-- <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/User_icon-cp.svg/1200px-User_icon-cp.svg.png" alt="user_img" height="200px"> -->
            <h3>Category Skills</h3>

            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Categories</th>
                </tr>
                <p style="color: red;">${msg_error}</p>
                </thead>
                <tbody>

                <c:forEach items="${categories}" var="cat">
                    <tr>
                        <td><c:out value="${cat}"/></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <!-- end column 2 -->
    </div>
    <!-- end row 2 -->



</div>
<!-- end container -->


</body>
</html>
