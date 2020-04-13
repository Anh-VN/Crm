<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Details</title>
</head>
<body>

           <div class="container-fluid">
               <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">${generalTask.name }</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="<c:url value="${ UrlConstants.URL_TASK_ADD }?id=${generalTask.id }" />" class="btn btn-sm btn-success">Thêm mới</a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                    
                <!-- BEGIN THỐNG KÊ -->
                <div class="row">
	                <c:forEach items="${ statusDto }" var="statusDto" varStatus="loop">
		                <!--col -->
	                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
	                        <div class="white-box">
	                            <div class="col-in row">
	                                <div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E"
	                                        class="linea-icon linea-basic"></i>
	                                    <h5 class="text-muted vb" style ="text-transform: uppercase" >${statusDto.name }</h5>
	                                </div>
	                                <div class="col-md-6 col-sm-6 col-xs-6">
	                                    <h3 class="counter text-right m-t-15 text-danger">${statusDto.percent}%</h3>
	                                </div>
	                                <div class="col-md-12 col-sm-12 col-xs-12">
	                                    <div class="progress">
	                                        <div class="progress-bar progress-bar-danger" role="progressbar"
	                                            aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </c:forEach>
                </div>
                <!-- END THỐNG KÊ -->

				<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
                <c:forEach items="${ listUserTasks }" var="userTasks" varStatus="loop">
                
                	<div class="row">
                    <div class="col-xs-12">
                        <a href="#" class="group-title">
                            <img width="30" src="<c:url value= "/assets/plugins/images/users/${userTasks.avatar }.jpg" />" class="img-circle" />
                            <span>${userTasks.userName }</span>
                        </a>
                    </div>
                     <c:forEach items="${ status }" var="status" varStatus="loop">
	                      <div class="col-md-4">
	                        <div class="white-box">
	                            <h3 class="box-title">${status.name }</h3>
	                            <div >                              
	                                    <div>
	                                        <c:forEach items="${ userTasks.tasks }" var="task" varStatus="loop">
	                                           <c:if test="${ task.statusId == status.id }">
	                                               <div class="message-center" style="width: 65%; float: left">
	                                                   <div class="mail-contnet">
	                                                      <h5>${ task.taskName }</h5>
		                                                  <span class="time">From ${ task.startDate } to ${ task.endDate }</span>
	                                                   </div>
	                                               </div>
	                                               <div>
	                                               		<a href="<c:url value="${ UrlConstants.URL_TASK_EDIT }?id=${ task.taskId }&generalTaskId=${generalTask.id }" />"  class="btn btn-sm btn-primary">Sửa</a> 
									       		        <a href="<c:url value="${ UrlConstants.URL_TASK_DELETE }?id=${ task.taskId }&generalTaskId=${generalTask.id }" />" class="btn btn-sm btn-danger">Xóa</a> 
	                                               </div>
	                                               <br/>                         
	                                           </c:if>
	                                        </c:forEach>                                        
	                                    </div>
	                           
	                            </div>
	                         </div>
	                       </div>                  
                     </c:forEach>                    
				</c:forEach>
				           
                <!-- END DANH SÁCH CÔNG VIỆC -->
            </div>    
</body>
</html>    
            