<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Edit User</title>
</head>

<body>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Cập nhật thành viên</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form action="<c:url value="${ UrlConstants.URL_USER_EDIT }" />" method="post" class="form-horizontal form-material">
					
					<input type="hidden" name="id" value="${ user.id }"/>
								
					<div class="form-group">
						<label class="col-md-12">Full Name</label>
						<div class="col-md-12">
							<input type="text" placeholder="Fullname" name="fullname" value="${ user.fullname }"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Email</label>
						<div class="col-md-12">
							<input type="email" placeholder="Email" name="email" value="${ user.email }"
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Password</label>
						<div class="col-md-12">
							<input type="password" placeholder="Enter new password" name="password" value=""
								class="form-control form-control-line" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Avatar</label>
						<div class="col-md-12">
							<select name="avatar" class="form-control form-control-line">
									<option value="arijit" ${ user.avatar == "arijit" ? 'selected' : '' }>arijit</option>
									<option value="genu" ${ user.avatar == "genu" ? 'selected' : '' }>genu</option>
									<option value="govinda" ${ user.avatar == "govinda" ? 'selected' : '' }>govinda</option>
									<option value="hritik" ${ user.avatar == "hritik" ? 'selected' : '' }>hritik</option>
									<option value="pawandeep" ${ user.avatar == "pawandeep" ? 'selected' : '' }>pawandeep</option>
									<option value="ritesh" ${ user.avatar == "ritesh" ? 'selected' : '' }>ritesh</option>
									<option value="sonu" ${ user.avatar == "sonu" ? 'selected' : '' }>sonu</option>
									<option value="varun" ${ user.avatar == "varun" ? 'selected' : '' }>varun</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Role</label>
						<div class="col-sm-12">
							<select name="roleId" class="form-control form-control-line">
								<c:forEach items="${ roles }" var="item">
									<option value="${ item.id }" ${ user.roleId == item.id ? 'selected' : '' }>${ item.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Edit User</button>
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

