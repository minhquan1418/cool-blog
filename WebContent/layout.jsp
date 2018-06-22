<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<c:import url="templates/common/head.jsp" />
</head>
<body>
	<!-- header -->
	<c:import url="templates/common/header.jsp" />
	<div class="clr"></div>

	<!-- content -->
	<div class="content">
		<div class="content_resize">
			<div class="mainbar">

				<!-- content file path  -->
				<c:import url="/templates/contents/${requestScope.contentFilePath}.jsp" />

			</div>
			<c:import url="/templates/common/sidebar.jsp" />
			<div class="clr"></div>
		</div>
	</div>

	<!-- footer -->
	<c:import url="templates/common/footer.jsp" />
</body>
</html>
