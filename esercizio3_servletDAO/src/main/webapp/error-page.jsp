<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <div class="row justify-content-md-center">
    <!-- column -->
    <div class="col-4 mt-3 text-center">

      <h1 style="color: red;">ERROR</h1>
      <div style="width: 100%;">
        <img src="https://i.pinimg.com/originals/e9/69/68/e96968684882f5f42402c0be1758d7cc.png" style="border-radius: 25px; width: 100%;">
      </div>
    </div>
    <!-- end column -->

    <!-- column 2 -->
    <div class="col-4 mt-3 text-center">

      <h3>Error message</h3>

      <div>
        <p>${msg-error}</p>
      </div>

    </div>
    <!-- end column 2 -->
  </div>
  <!-- end row -->
</div>
<!-- end container -->



</body>
</html>




