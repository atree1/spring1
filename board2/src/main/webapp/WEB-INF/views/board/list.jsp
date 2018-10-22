<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">List</h1>
	</div>
	<a href="/board/register">Register</a>
	<!-- /.col-lg-12 -->
	${pageObj}
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board List</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>BNO</th>
								<th>TITLE</th>
								<th>WRITER</th>
								<th>REGDATE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="board">
								<tr>
									<td><c:out value="${board.bno}" /></td>
									<td><a href="${board.bno}" class='board'><c:out
												value="${board.title}" /></a></td>
									<td><c:out value="${board.writer}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
											value="${board.regdate}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<div class='search'>
		<input class='type' type="checkbox" name='type' value='t'>제목 <input
			class='type' type="checkbox" name='type' value='c'>내용 <input
			class='type' type="checkbox" name='type' value='w'>작성자 <input
			id='keyword' type="text" name='keyword'></input>
		<button id='searchBtn'>검색</button>

	</div>
	<div class="col-sm-12">
		<div class="dataTables_paginate paging_simple_numbers"
			id="dataTables-example_paginate">
			<ul class="pagination">
				<c:if test="${pageObj.prev}">
					<li class="paginate_button previous disabled"
						aria-controls="dataTables-example" tabindex="0"
						id="dataTables-example_previous"><a
						href="${pageObj.start-1 }">Previous</a></li>
				</c:if>
				<c:forEach begin="${pageObj.start}" end="${pageObj.end }" var="num">
					<li class="paginate_button" data-page='${num}'
						aria-controls="dataTables-example" tabindex="0"><a
						href="${num}"><c:out value="${num}" /></a></li>

				</c:forEach>
				<c:if test="${pageObj.next }">
					<li class="paginate_button next" aria-controls="dataTables-example"
						tabindex="0" id="dataTables-example_next"><a
						href="${pageObj.end+1}">Next</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<form id='actionForm'>
		<input type='hidden' name='pageParam' id='page' value='${pageObj.page }'> 
			<input type='hidden' name='types' value='${pageObj.types}'> 
			<input type='hidden' name='keyword' value='${pageObj.keyword}'>

	</form>
</div>


<%@include file="../includes/footer.jsp"%>

<script>
	$(document).ready(function() {

						var actionForm = $('#actionForm');
						var currentNum = ${pageObj.page};
						var searchForm = $('#searchForm');
						$('#searchBtn').on("click", function(e) {
							e.preventDefault();
							var type = $('.type');
							var types = [];
							var keyword = $('#keyword').val();

							for (var i = 0; i < type.length; i++) {

								if (type[i].checked) {
									types.push(type[i].value);

								}
							}

							actionForm.attr("action", "/board/list");
							actionForm.find("input[name='types']").val(types);
							actionForm.find("input[name='keyword']").val(keyword);
							$("#page").val(1);
							
							actionForm.submit();
							
						});

						$('.board').on('click',function(e) {
											e.preventDefault();
											var bno = $(this).attr('href');
											actionForm
													.append("<input type='hidden' name='bno' value='"+bno+"'>");
											actionForm.attr("action",
													'/board/read').attr(
													'method', 'get').submit();
										});
						$('.pagination li[data-page=' + currentNum + ']')
								.addClass("active");

						$('.pagination li a').on(
								'click',
								function(e) {
									e.preventDefault();
									var target = $(this).attr('href');
									$("#page").val(target);
									actionForm.attr("action", "/board/list")
											.attr("method", 'get').submit();

								});

						var result = '<c:out value="${result}"/>';
						var msg = $('#myModal');
						if (result === 'SUCCESS') {
							$(".modal-body").html("작업 완료 !!");
							msg.modal("show()");
						}
					});
</script>