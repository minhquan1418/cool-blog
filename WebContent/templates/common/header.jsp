<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
	<div class="header_resize">
		<div class="logo">
			<h1>
				<a href="/cool-blog">Cool <span>Blog</span></a><small>It is
					cool</small>
			</h1>
		</div>
		<div class="clr"></div>
		<div class="menu_nav">
			<ul>
				<c:forEach items="${topMenus}" var="topMenu">
					<li><a href="${topMenu.link}">${topMenu.title}</a></li>
				</c:forEach>
			</ul>
			<div class="search">
				<form id="form" name="form" method="post" action="#">
					<span> <input name="q" type="text" class="keywords"
						id="textfield" maxlength="50" /> <input name="b" type="image"
						src="images/search.gif" class="button" />
					</span>
				</form>
			</div>
			<!--/search -->
		</div>
		<div class="clr"></div>
	</div>
</div>