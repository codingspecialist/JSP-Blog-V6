<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form action="${cp}/user?cmd=login" method="post">
	
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter username" name="username"  value="" required="required" />
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="Enter password" name="password" required="required" />
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input class="form-check-input" type="checkbox" name="rememberMe"> Remember me
			</label>
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
		
	</form>
	
</div>

<%@ include file="../layout/footer.jsp"%>
