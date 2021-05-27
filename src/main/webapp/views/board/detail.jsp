<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<c:if test="${principal.id == dto.userId}">
		<a href="#" class="btn btn-warning">수정</a>
		<form action="${cp}/board?cmd=delete" method="post">
			<input type="hidden" name="id" value="${dto.id}" />
			<button id="btn-delete" class="btn btn-danger" type="submit">삭제</button>
		</form>
		
	</c:if>
	<br /><br />
	<div>
		글 번호 : ${dto.id}</span> 작성자 : <span><i>${dto.username} </i></span>
	</div>
	<br />
	<div>
		<h3>${dto.title}</h3>
	</div>
	<hr />
	<div>
		<div>${dto.content }</div>
	</div>
	<hr />

	<div class="card">
		<form>
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
			</div>
		</form>
	</div>
	<br />
	<div class="card">
		<div class="card-header"><b>댓글 리스트</b></div>
		<ul id="reply-box" class="list-group">
			<li id="reply-1" class="list-group-item d-flex justify-content-between">
				<div>댓글입니다</div>
				<div class="d-flex">
					<div class="font-italic">작성자 : 홍길동 &nbsp;</div>
					<button class="badge">삭제</button>
				</div>
			</li>
		</ul>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>
