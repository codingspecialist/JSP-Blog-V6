<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="${cp}/user?cmd=join" method="post">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter username"  name="username" required="required"/>
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="Enter password" name="password" required="required"/>
		</div>
		<div class="form-group"> 
			<input type="email" class="form-control" placeholder="Enter email" name="email" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter address" name="address" required="required"/>
		</div>
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>
