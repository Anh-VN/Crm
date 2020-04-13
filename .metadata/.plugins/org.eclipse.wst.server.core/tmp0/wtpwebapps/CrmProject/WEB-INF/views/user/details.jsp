<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>User Details</title>
</head>


<body>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Chi tiết thành viên</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-4 col-xs-12">
			<div class="white-box">
				<div class="user-bg">
					<img width="100%" alt="user" src="<c:url value="/assets/plugins/images/large/img1.jpg" />">
					<div class="overlay-box">
						<div class="user-content">
							<a href="javascript:void(0)"><img
								src="<c:url value="/assets/plugins/images/users/${user.avatar }.jpg"/>" class="thumb-lg img-circle"
								alt="img"></a>
							<h4 class="text-white">${user.fullname }</h4>
						</div>
					</div>
				</div>
				<div class="user-btm-box">
					<c:forEach items="${ statusDto }" var="statusDto" varStatus="loop">
					    <div class="col-md-4 col-sm-4 text-center">
						<p class="text-purple">
							<i class="ti-facebook"></i>
						</p>
						<h4>${statusDto.percent }%</h4>
						<h6>${statusDto.name }</h6>
					</div>
					</c:forEach>				
				</div>
			</div>
		</div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material">
					<div class="form-group">
						<label class="col-md-12">Full Name</label>
						<span style="margin-left:9px">${user.fullname }</span>
					</div>
					<div class="form-group">
						<label for="example-email" class="col-md-12">Email</label>
						<span style="margin-left:9px">${user.email }</span>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Role</label>
						<span style="margin-left:9px">${user.roleName }</span>
					</div>
					<div class="form-group">
						<label class="col-sm-12"></label>
					</div>
					<div class="form-group">
						<label class="col-sm-12"></label>
					</div>	
					<div class="form-group">
						<label class="col-sm-12"></label>
					</div>	
				</form>
			</div>
		</div>
	</div>
	<br />
	<!-- /.row -->
	<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
	<c:forEach items="${ listUserTasks }" var="userTasks" varStatus="loop">            
                	<div class="row">
                     <c:forEach items="${ status }" var="status" varStatus="loop">
	                      <div class="col-md-4">
	                        <div class="white-box">
	                            <h3 class="box-title">${status.name }</h3>
	                            <div >                              
	                                    <div>
	                                        <c:forEach items="${ userTasks.tasks }" var="task" varStatus="loop">
	                                           <c:if test="${ task.statusId == status.id }">
	                                               <div class="message-center" style="width: 65%; float: left">
	                                                   <div class="mail-contnet" >
	                                                      <h5>${ task.taskName }</h5>
		                                                  <span class="time">From ${ task.startDate } to ${ task.endDate }</span>
	                                                   </div>
	                                               </div>
	                                               <div>
	                                                 	<a href="<c:url value="${ UrlConstants.URL_TASK_STATUS }?id=${ task.taskId }" />"  class="btn btn-sm btn-primary">Cập nhật</a>		                                  		 
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


