<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
	<div class="left">
			<h1>Edit information account</h1>
			<form name="signup-form" action="EditAccount" method="post">
			<div>
					<input type="text" name="usermail" class="input-box"
						placeholder="Input your email" value="${account.getUsr()}">
				</div>
				<div>
					<input type="text" name="password" class="input-box"
						placeholder="Input your address" value="${account.getPwd()}">
				</div>
				<div>
					<input type="text" name="username" class="input-box"
						placeholder="Input your username" value="${account.getName()}">
				</div>
				
				<div>
					<input type="text" name="address" class="input-box"
						placeholder="Input your address" value="${account.getAddress()}">
				</div>
				<div>
					<input type="text" name="role" class="input-box"
						placeholder="Input your address" value="${account.getRole()}">
				</div>
				<div>
					<input type="text" name="phone" class="input-box"
						placeholder="Input your phone" value="${account.getPhone()}">
				</div>
				
				<div>
					<input class="submit-button" type="submit" value="Update" style="background: green;">
				</div>
			</form>
		</div>
