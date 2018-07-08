<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Category Information</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-12">
						<form role="form" method="post"
							action='<c:url value="/admin/category-update"/>'>
							<div class="form-group">
								<label>ID</label> <input class="form-control" name="id"
									type="text" value="${category.id}" readonly>
							</div>
							<div class="form-group">
								<label>Name</label> <input class="form-control" name="name"
									value="${category.name}">
							</div>
							<div class="form-group">
								<label>Number Of Articles</label> <input class="form-control"
									name="numberOfArticles" type="text"
									value="${category.numberOfArticles}" disabled>
							</div>
							<button type="submit" class="btn btn-default">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>