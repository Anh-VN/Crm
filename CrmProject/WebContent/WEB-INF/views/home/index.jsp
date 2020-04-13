<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>  
    <title>Home Page</title>       
    <!-- toast CSS -->
    <link href="<c:url value ="/assets/plugins/bower_components/toast-master/css/jquery.toast.css"/>" rel="stylesheet">
    <!-- morris CSS -->
    <link href="<c:url value ="/assets/plugins/bower_components/morrisjs/morris.css" />" rel="stylesheet">
</head>
    
<body>
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Dashboard</h4>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	
	<!--row -->
	<div class="row">
		<div class="col-md-12">
			<div class="white-box">
				<h3 class="box-title">Sales Difference</h3>
				<ul class="list-inline text-right">
					<li>
						<h5><i class="fa fa-circle m-r-5" style="color: #dadada;"></i>Site A View</h5>
					</li>
					<li>
						<h5><i class="fa fa-circle m-r-5" style="color: #aec9cb;"></i>Site B View</h5>
					</li>
				</ul>
				<div id="morris-area-chart2" style="height: 370px;"></div>
			</div>
		</div>
	</div>  
	
	<content tag = "scripts">
        <!--slimscroll JavaScript -->
        <script src="<c:url value="/assets/js/jquery.slimscroll.js"/>"></script>
        <!--Wave Effects -->
	 	<script src="<c:url value="/assets/js/waves.js"/>"></script>
	    <!--Counter js -->
	    <script src="<c:url value="/assets/plugins/bower_components/waypoints/lib/jquery.waypoints.js"/>"></script>
	    <script src="<c:url value="/assets/plugins/bower_components/counterup/jquery.counterup.min.js"/>"></script>
	    <!--Morris JavaScript -->
	    <script src="<c:url value="/assets/plugins/bower_components/raphael/raphael-min.js"/>"></script>
	    <script src="<c:url value="/assets/plugins/bower_components/morrisjs/morris.js"/>"></script>
	    <!-- Custom Theme JavaScript -->
	    <script src="<c:url value="/assets/js/custom.min.js"/>"></script>
	    <script src="<c:url value="/assets/js/dashboard1.js"/>"></script>
	    <script src="<c:url value="/assets/plugins/bower_components/toast-master/js/jquery.toast.js"/>"></script>
    </content>   		
</body>
   
</html>