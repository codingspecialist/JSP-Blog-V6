<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String cp = request.getContextPath(); // => /blog
pageContext.setAttribute("cp", cp);
%>
<!DOCTYPE html>
<html>
<head>
<title>Blog</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<link href="${cp}/static/css/style.css" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="${cp}">Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">

				<c:choose>
					<c:when test="${empty principal}">
						<li class="nav-item"><a class="nav-link" href="${cp}/user?cmd=joinForm">회원가입</a></li>
						<li class="nav-item"><a class="nav-link" href="${cp}/user?cmd=loginForm">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="${cp}/board?cmd=saveForm">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="${cp}/user?cmd=updateForm">회원정보변경</a></li>
						<li class="nav-item"><a class="nav-link" href="${cp}/user?cmd=logout">로그아웃</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>

	</nav>
	<br>