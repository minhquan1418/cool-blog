<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:forEach items="${articles}" var="article">
	<div class="article">
		<h2>${article.name}</h2>
		<div class="clr"></div>
		<p>
			Posted on:
			<fmt:formatDate value="${article.creationTime}" pattern="yyyy-MM-dd" />
			Category: ${article.category.name}
		</p>
		<p>
			<a href=<c:url value="/article-single?id=${article.id}"/>>Read
				more </a>
		</p>
		<div class="clr"></div>
	</div>
</c:forEach>

<div class="article"
	style="padding: 5px 20px 2px 20px; background: none; border: 0;">
	<p>
		<span class="butons"> <c:forEach var="i" begin="1" end="1">
				<a
					href=<c:url value="/category?id=${idCategory}&page=${pageTotal -i + 1}"/>
					<c:if test="${pageNumber == pageTotal -i + 1}">class="active"</c:if>>${pageTotal -i + 1}</a>
			</c:forEach>
		</span>
	</p>
</div>