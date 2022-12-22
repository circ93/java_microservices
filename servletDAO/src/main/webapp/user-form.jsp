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
  <div class="row">
    <!-- column -->
    <div class="col-6 mt-3">

      <form method="post" action="ServletInserUser">
        <div class="mb-3">
          <label  class="form-label">Nome</label>
          <input type="text" class="form-control" name="name" required="required">
        </div>
        <div class="mb-3">
          <label class="form-label">email</label>
          <input type="text" class="form-control" name="email" required="required">
        </div>
        <div class="mb-3">
          <label  class="form-label">Stato</label>
          <input type="text" class="form-control" name="country" required="required">
        </div>
        <button type="submit" class="btn btn-success">Save</button>
      </form>

      <p style="color: green;">${msg}</p>


    </div>
    <!-- end column -->
  </div>
  <!-- end row -->
</div>
<!-- end container -->



</body>
</html>




