<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task status</title>
</head>
<body>
<div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Cập nhật công việc</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form action="<c:url value="" />" method="post" class="form-horizontal form-material">
                                
                                <div class="form-group">
                                    <div class="col-md-12">
                                    <input type="hidden" name="id" value="${task.id }"> </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <input type="hidden" readonly="true"
                                            class="form-control form-control-line" name="userId" value="${task.userId }"> </div>
                                </div>
                                                     
                                <div class="form-group">
                                    <label class="col-md-12">Tên công việc</label>
                                    <div class="col-md-12">
                                        <input type="text" readonly="true"
                                            class="form-control form-control-line" name="name" value="${task.name }"> </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-12">Status</label>
                                    <div class="col-md-3">
	                                    <select name="statusId" class="form-control form-control-line">
											<c:forEach items="${ status }" var="item">
												<option value="${ item.id }" ${ task.statusId == item.id ? 'selected' : '' }>${ item.name }</option>
											</c:forEach>
								        </select>
                                    </div>
                                </div>    
                                
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Lưu lại</button>
                                        <a href="<c:url value="${ UrlConstants.URL_USER_DETAILS }?id=${USER_LOGIN.id}" />" class="btn btn-primary">Quay lại</a>
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