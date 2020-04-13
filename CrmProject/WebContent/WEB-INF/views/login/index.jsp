<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%-- <input type = "hidden" id = "textNotify" value = "${notify}" /> --%>
<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
      <div class="text-center">
	      <h3>ĐĂNG NHẬP HỆ THỐNG</h3>
	      <p class="text-danger">${message }</p>
      </div>
      <div class="p-4 border mt-4">
      
        <form action="<c:url value ="/login" />" method="POST" > 
            <div class="form-group">
              <label>Email</label>
              <input type="email" class="form-control" name="email" value = "${email }">
            </div>
            <div class="form-group">
              <label>Mật khẩu</label>
              <input type="password" class="form-control" name="password"  value = "${password }">
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
          </form>
          
      </div>
      </div>
  </div>
</div>

<content tag = "scripts">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!-- <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
             var message = document.getElementById("textNotify").value;
             if(message !== null & message.length > 0)
             {swal("Notify!", message, "success");}
	</script> -->
</content>

    
</body>
</html>
