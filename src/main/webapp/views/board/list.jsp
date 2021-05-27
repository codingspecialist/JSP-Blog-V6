<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<c:forEach var="board" items="${boards}">
		<!-- 게시글 아이템 시작 -->
		<div class="card gap_b_20">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<a href="${cp}/board?cmd=detail&id=${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		<!-- 게시글 아이템 종료 -->
	</c:forEach>

	
	<ul class="pagination">
		<c:choose>
			<c:when test="${param.page == 0}">
				<li class="page-item disabled"><a class="page-link" href="${cp}/board?cmd=list&page=${param.page - 1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="${cp}/board?cmd=list&page=${param.page - 1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		
		<li class="page-item"><a class="page-link" href="${cp}/board?cmd=list&page=${param.page + 1}"">Next</a></li>
	</ul>

</div>

<%@ include file="../layout/footer.jsp"%>
