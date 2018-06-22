<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div id="wrapper">

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href='<c:url value="/admin"/>'>Admin</a>
		</div>

		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<ul class="nav navbar-nav navbar-left navbar-top-links">
			<li><a href="<c:url value="/"/>"><i class="fa fa-home fa-fw"></i> Cool-blog</a></li>
		</ul>

		<ul class="nav navbar-right navbar-top-links">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<c:out value="${username}" /> <b class="caret"></b>
			</a>
				<ul class="dropdown-menu dropdown-user">
				<!-- <li><a href="#"><i class="fa fa-user fa-fw"></i> User -->
				<!-- 	Profile</a></li> -->
				<!-- <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a> -->

				<li><a href="<c:url value="/admin-logout"/>"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>
				</ul></li>
		</ul>
		<!-- /.navbar-top-links -->