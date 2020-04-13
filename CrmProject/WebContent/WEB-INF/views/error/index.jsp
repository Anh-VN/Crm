<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link href="<c:url value="/assets/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>

   <div id="wrapper" class="error-page" style="margin-top: 150px; ">
        <div class="error-box">
            <div class="error-body text-center">
                <h2>BẠN KHÔNG CÓ QUYỀN TRY CẬP!</h2>
                <p class="text-muted m-t-30 m-b-30">YOU DON'T HAVE PERMISSION TO ACCESS</p>
                <a href="<c:url value="${UrlConstants.URL_HOME }" />" class="btn btn-info btn-rounded waves-effect waves-light m-b-40">Về trang chủ</a> </div>
            <footer class="footer text-center">2018 © Pixel Admin.</footer>
        </div>
    </div>
</body>
</html>