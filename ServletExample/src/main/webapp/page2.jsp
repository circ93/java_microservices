<%--
  Created by IntelliJ IDEA.
  User: Gianluca
  Date: 22/12/2022
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <title>Java Servlet</title>
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<header>
  <jsp:include page="navbar.jsp"></jsp:include>
</header>


<!-- container -->
<div class="container">
  <!-- row -->
  <div class="row">
    <!-- column -->
    <div class="col-5 mt-3">

      Il nome inserito nella form è ${nomeForm}

    </div>
    <!-- end column -->
  </div>
  <!-- end row -->
</div>
<!-- end container -->



</body>
</html>

