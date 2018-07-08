<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Check if user already login, if so redirect to default page -->
<c:if test="${sessionScope.username != null}">
	<c:redirect url="${applicationScope['defaultAdminView'].link}" />
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Cool Blog Admin Panel</title>

<!-- Bootstrap Core CSS -->
<link href='<c:url value="/admin/css/bootstrap.min.css" />'
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href='<c:url value="/admin/css/metisMenu.min.css" />'
	rel="stylesheet">

<!-- Custom CSS -->
<link href='<c:url value="/admin/css/startmin.css" />' rel="stylesheet">

<!-- Custom Fonts -->
<link href='<c:url value="/admin/css/font-awesome.min.css" />'
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.admin/js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" method="POST"
							action=<c:url value="/admin-login"/>>
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Username"
										name="username" type="text" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me">Remember Me
									</label>
								</div>

								<c:if test='${requestScope["notification"] != null}'>
									<div class="alert alert-warning">
										<c:out value='${requestScope["notification"]}' />
									</div>
								</c:if>

								<!-- Change this to a button or input when using this as a form -->
								<button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="admin/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="admin/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="admin/js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="admin/js/startmin.js"></script>

</body>
</html>
