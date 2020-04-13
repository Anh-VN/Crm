<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crm.util.UrlConstants" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html lang="en">

<head>
    <title>User Page</title>
</head>

<body>
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Danh sách thành viên</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="<c:url value="${ UrlConstants.URL_USER_ADD }" />" class="btn btn-sm btn-success">Thêm mới</a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <div class="table-responsive">
                                <table class="table" id="example">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                           <!-- <th>Address</th> --> 
                                            <th>Role</th>
                                            <th>Hành động</th>
                                        </tr>
                                        
                                    </thead>
                                    <tbody>
                                    
                                        <c:forEach items="${ users }" var="item" varStatus="loop">
											<tr>
												<td>${ loop.index + 1 }</td>
												<td>${ item.fullname }</td>
												<td>${ item.email }</td>
												<%-- <td>${ item.email}</td> --%>
												<td>${ item.roleName }</td>
												<td>
													<a 
														href="<c:url value="${ UrlConstants.URL_USER_EDIT }?id=${ item.id }" />" 
														class="btn btn-sm btn-primary">Sửa
													</a> 
													<a
														href="<c:url value="${ UrlConstants.URL_USER_DELETE }?id=${ item.id }" />" 
														class="btn btn-sm btn-danger">Xóa
													</a>
													<a
														href="<c:url value="${ UrlConstants.URL_USER_DETAILS }?id=${ item.id }" />" 
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