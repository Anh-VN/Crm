<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Edit Role</title>
</head>

<body>
  <div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Cập nhật quyền</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form action="<c:url value="${ UrlConstants.URL_ROLE_EDIT }" />" 
					method="post" class="form-horizontal form-material">
					
					<input type="hidden" name="id" value="${ role.id }" />
					
					<div class="form-group">
						<label class="col-md-12">Tên quyền</label>
						<div class="col-md-12">
							<input type="text" placeholder="Tên quyền" name="name" value="${ role.name }"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Mô tả</label>
						<div class="col-md-12">
							<input type="text" placeholder="Mô tả" name="description" value="${ role.description }"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Edit Role</button>
							<a href="<c:url value="${ UrlConstants.URL_ROLE_LIST }" />" 
								class="btn btn-primary">Quay lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
	<!-- /.row -->
</div>
</body>

</html>
