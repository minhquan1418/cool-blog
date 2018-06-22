<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div clss="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Articles list</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="dataTable_wrapper">
					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">

						<!-- table -->
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Creation date</th>
											<th>Category</th>
											<th>Action</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${articles}" var="article">
											<tr>
												<td><c:out value="${article.id}" /></td>
												<td><c:out value="${article.name}" /></td>
												<td><c:out value="${article.creationTime}" /></td>
												<td><c:out value="${article.category.name}" /></td>
												<td><a type="button" class="btn btn-primary btn-circle"
													href="article-update?id=${article.id}"><i
														class="fa fa-pencil"></i></a> <a type="button"
													class="btn btn-danger btn-circle"
													href="article-delete?id=${article.id}"><i
														class="fa fa-trash"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>


						<div class="row">

							<!-- add button -->
							<div class="col-sm-6">
								<div class="dataTables_info" id="dataTables-example_info"
									role="status" aria-live="polite">
									<a type="button" class="btn btn-primary"
										href='<c:url value="/admin/article-add"/>'>Add article</a>
								</div>
							</div>

							<!-- pagination -->
							<div class="col-sm-6">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTables-example_paginate">
									<ul class="pagination">
										<li class="paginate_button"><a
											href='<c:url value="/admin/article-list?page=1"/>'>First</a></li>
										<c:forEach var="i" begin="1" end="${pageTotal}">
											<li
												class="paginate_button <c:if test="${i==pageNumber}">active</c:if> "><a
												href='<c:url value="/admin/article-list?page=${i}"/>'>${i}</a></li>
										</c:forEach>
										<li class="paginate_button"><a
											href='<c:url value="/admin/article-list?page=${pageTotal}"/>'>Last</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
	</div>
</div>