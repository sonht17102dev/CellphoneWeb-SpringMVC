<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="containerRegister">
	<div class="left">
		<h1>Create new account</h1>

		<form name="signup-form" method="post" action="createAccount">
			<div>
				<input type="text" name="username" id="username" class="input-box"
					placeholder="Please input username">
			</div>
			<div>
				<input type="text" name="address" id="address" class="input-box"
					placeholder="Please input address">
			</div>
			<div>
				<input type="text" name="phone" id="phone" class="input-box"
					placeholder="Please input phone">
			</div>
			<div>
				<input type="text" name="usermail" id="usermail" class="input-box"
					placeholder="Please input usermail">
			</div>
			<div>
				<input type="password" name="password" id="password"
					class="input-box" placeholder="Please input username">
			</div>
			<div>
				<input class="submit-button" type="submit" value="Submit"
					style="background: green;">
			</div>
		</form>
	</div>
	<div class="right">
		<div class="content">
			<h1>Welcome new partner!</h1>
			<p>
				To keep connected with us <br>please input with your personal
				info<br>

			</p>
			<p style='color: red'>${mess}</p>
		</div>
	</div>
</div>
