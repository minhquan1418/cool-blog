<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidebar">
	<div class="gadget">
		<h2>Categories</h2>
		<div class="clr"></div>
		<ul class="sb_menu">
			<c:forEach items="${categoriesList}" var="category">
				<li><a href="category?id=${category.id}">${category.name}</a></li>
			</c:forEach>
		</ul>
	</div>
</div>