<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board MODify/Delete</div>
			<!-- /.panel-heading -->
			<form role="form" action="/board/modify" method="post">

				<div class="panel-body">
					<div class="form-group">
						<label>Title</label> <input class="form-control" name='title'
							value='<c:out value="${board.title}"/>'>
						<p class="help-block">Example block-level help text here.</p>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name='writer'
							value='<c:out value="${board.writer}" />' readonly="readonly">
						<p class="help-block">Example block-level help text here.</p>
					</div>

					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" name='content' rows="3"><c:out
								value="${board.content}" /></textarea>
					</div>
					<div>
						<input type="hidden" name='bno' value='${board.bno}'>
						<button class="btn btn-default">수정</button>
					</div>
				</div>
			</form>
			<form role="form" action="/board/list">
				<input type='hidden' name='page' value='${pageObj.page}'>
				<button class="btn btn-default">목록</button>
			</form>

			<form role="form" action="/board/remove" method="post">
				<input type='hidden' name='page' value='${pageObj.page}'> <input
					type='hidden' name='bno' value='${pageObj.bno}'>
				<button class="btn btn-default">삭제</button>
			</form>
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->

</div>




<%@include file="../includes/footer.jsp"%>

</body>

</html>