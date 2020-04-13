<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Work Page</title>
</head>
<body>
<!-- row -->
	
       <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Danh sách công việc</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="<c:url value="${ UrlConstants.URL_GENERALTASK_ADD }" />" class="btn btn-sm btn-success">Thêm mới</a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
		<!--col -->		
	    <c:forEach items="${ statusDto }" var="statusDto" varStatus="loop">
		    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			    <div class="white-box">
				<div class="col-in row">
					<div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E"
	                                    class="linea-icon linea-basic"></i>
						<h5 class="text-muted vb" style ="text-transform: uppercase">${statusDto.name }</h5>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-6">
						<h3 class="counter text-right m-t-15 text-danger">${statusDto.numberOfTask}</h3>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="progress">
							<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40"
	                                        aria-valuemin="0" aria-valuemax="100" style="width: ${statusDto.percent}%"> <span
	                                            class="sr-only">${statusDto.percent}% Complete (success)</span> </div>
						</div>
					</div>
				</div>
			</div>
	     	</div>      
	    </c:forEach>
	</div>
	<!-- /.row -->
	
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <div class="table-responsive">
                                <table class="table" id="example">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Tên Công Việc</th>
                                            <th>Ngày Bắt Đầu</th>
                                            <th>Ngày Kết Thúc</th>
                                            <th>Hành Động</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      
                                         <c:forEach items="${ generalTasks }" var="item" varStatus="loop">
											<tr>
												<td>${ loop.index + 1 }</td>
												<td>${ item.name }</td>
												<td>${ item.startDate }</td>
												<td>${ item.endDate}</td>
											
												<td>
													<a 
														href="<c:url value="${ UrlConstants.URL_GENERALTASK_EDIT }?id=${ item.id }" />" 
														class="btn btn-sm btn-primary">Sửa
													</a> 
													<a
														href="<c:url value="${ UrlConstants.URL_GENERALTASK_DELETE }?id=${ item.id }" />" 
														class="btn btn-sm btn-danger">Xóa
													</a>
													<a
														href="<c:url value="${ UrlConstants.URL_GENERALTASK_DETAILS }?id=${ item.id }" />" 
														class="btn btn-sm btn-info">Xem
													</a>
												</td>
											</tr>
							            </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
                
    <content tag = "scripts">       
        <script>
          $(document).ready(function () {
            $('#example').DataTable();
          });
       </script>          
    </content>
                
                
</body>
</html>