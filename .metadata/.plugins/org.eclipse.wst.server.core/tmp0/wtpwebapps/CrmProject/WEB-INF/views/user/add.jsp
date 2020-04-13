<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>New User</title>
</head>


<body>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Thêm mới thành viên</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form action="<c:url value="${ UrlConstants.URL_USER_ADD }" />" method="post" class="form-horizontal form-material">
					<div class="form-group">
						<label class="col-md-12">Full Name</label>
						<div class="col-md-12">
							<input type="text" placeholder="Fullname" name="fullname"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Email</label>
						<div class="col-md-12">
							<input type="email" placeholder="Email" name="email"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Password</label>
						<div class="col-md-12">
							<input type="password" placeholder="Password" name="password"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Avatar</label>
						<div class="col-md-12">
							<select name="avatar" class="form-control form-control-line">
									<option value="arijit">arijit</option>
									<option value="genu">genu</option>
									<option value="govinda">govinda</option>
									<option value="hritik">hritik</option>
									<option value="pawandeep">pawandeep</option>
									<option value="ritesh">ritesh</option>
									<option value="sonu">sonu</option>
									<option value="varun">varun</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Role</label>
						<div class="col-sm-12">
							<select name="roleId" class="form-control form-control-line">
								<c:forEach items="${ roles }" var="item">
									<option value="${ item.id }">${ item.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Add User</button>
							<a href="<c:url value="${ UrlConstants.URL_USER_LIST }" />" class="btn btn-primary">Quay lại</a>
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

