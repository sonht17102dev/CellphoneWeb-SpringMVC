<%@page import="java.util.Arrays"%>
<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
	<div class="containerRegister">
		<div class="left">
			<h1>Register</h1>
			<form name="signup-form" action="signup" method="post">
				<div>
					<input type="text" name="username" class="input-box"
						placeholder="Input your username">
				</div>
				<div>
					<input type="text" name="address" class="input-box"
						placeholder="Input your address">
				</div>
				<div>
					<input type="text" name="phone" class="input-box"
						placeholder="Input your phone">
				</div>
				<div>
					<input type="text" name="usermail" class="input-box"
						placeholder="Input your email">
				</div>
				<div>
					<input type="password" name="password" class="input-box"
						placeholder="Input your password">
				</div>
				<div>
					<input type="password" name="repassword" class="input-box"
						placeholder="Reinput your password">
				</div>
				<div>
					<input class="submit-button" type="submit" value="Register Now" style="background: green;">
				</div>
			</form>
		</div>
		<div class="right">
			<div class="content">
				<h1>Welcome new partner!</h1>
				<p>
				To keep connected with us <br>please input with your personal info<br>
				
				</p>
				<p></p>
			</div>
		</div>
	</div>
