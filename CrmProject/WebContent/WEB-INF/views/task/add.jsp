<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Task</title>
</head>
<body>
<div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Edit công việc</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form action="<c:url value="${ UrlConstants.URL_TASK_ADD }" />" method="post" class="form-horizontal form-material">
                                <div class="form-group">
                                    <label class="col-md-12">Tên công việc</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Tên công việc"
                                            class="form-control form-control-line" name="name" > </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày bắt đầu</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="YYYY/MM/DD"
                                            class="form-control form-control-line" name="startDate" > </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày kết thúc</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="YYYY/MM/DD"
                                            class="form-control form-control-line" name="endDate"  > </div>
                                </div>           
                               <div class="form-group">
                                    <label class="col-md-12">User</label>
                                    <div class="col-md-3">
	                                    <select name="userId" class="form-control form-control-line">
											<c:forEach items="${ users }" var="item">
												<option value="${ item.id }" >${ item.fullname }</option>
											</c:forEach>
								        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">General Task</label>
                                    <div class="col-md-3">
	                                    <select name="generalTaskId" class="form-control form-control-line">
											<c:forEach items="${ generalTasks }" var="item">
												<option value="${ item.id }" ${ generalTaskId == item.id ? 'selected' : '' }>${ item.name }</option>
											</c:forEach>
								        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Status</label>
                                    <div class="col-md-3">
	                                    <select name="statusId" class="form-control form-control-line">
											<c:forEach items="${ status }" var="item">
												<option value="${ item.id }" >${ item.name }</option>
											</c:forEach>
								        </select>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Lưu lại</button>
                                        <a href="<c:url value="${ UrlConstants.URL_GENERALTASK_DETAILS }" />" class="btn btn-primary">Quay lại</a>
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