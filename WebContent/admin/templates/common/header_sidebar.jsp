<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">

			<c:forEach items="${applicationScope['sideBarItems']}" var="item">
				<li><a href="<c:url value="/admin/${item.link}"/>"> <i
						class="fa fa-dashboard fa-fw"></i> <c:out value="${item.title}" />
				</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
</nav>