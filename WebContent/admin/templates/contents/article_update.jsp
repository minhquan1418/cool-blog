<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Article Information</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-12">
						<form role="form" method="post"
							action='<c:url value="/admin/article-update"/>'>
							<div class="form-group">
								<label>ID</label> <input class="form-control" name="id"
									type="text" value="${article.id}" readonly>
							</div>

							<div class="form-group">
								<label>Name</label> <input class="form-control" name="name"
									value="${article.name}">
							</div>

							<div class="form-group">
								<label>Content</label>
								<textarea class="form-control" rows="5" name="content"
									id="content">${article.content}</textarea>
							</div>
							<script>
								CKEDITOR.replace('content', {
									language : 'en'
								});
							</script>

							<div class="form-group">
								<label>Creation Time</label> <input class="form-control"
									name="creationTime" type="text"
									value="<fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" value = "${article.creationTime}" />">
							</div>

							<div class="form-group">
								<label>Category</label> <select class="form-control"
									name="idCategory">
									<c:forEach items="${categories}" var="category">
										<option value="${category.id}"
											<c:if test="${category.id == article.category.id }">selected</c:if>>
											${category.name}</option>
									</c:forEach>

								</select>
							</div>

							<button type="submit" class="btn btn-default">Update</button>

						</form>
					</div>
					<!-- /.col-lg-6 (nested) -->

					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>