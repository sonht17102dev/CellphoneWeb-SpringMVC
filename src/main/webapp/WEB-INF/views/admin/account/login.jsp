<%@ page language="java" contentType="text/html; charset=UtF-8"
    pageEncoding="UtF-8"%>
    
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>

	<div class="containerLogin">
	    <div class="leftLogin">
	      <h1>Sign in</h1>
	      
	      <form name="login-form" action="/CellPhoneShop/admin/checkLogin"  method="post"> 
	        <div><input type="text" name="username" class="input-box" placeholder="Input your email"></div>
	        <div><input type="password" name="password" class="input-box" placeholder="Input your password"></div>
	        <div><span><a href="#" title="forgot" class="forgot">Forgot your password</a></span></div>
	        
	        <div class="remember">
	          <input type="checkbox" name="remember">
	          <label for="remember">Remember me</label>
	        </div>
	        <input class="submit-button" type="submit" value="LOGIN">
	        
	      </form>
	      
	     
	      <a href="signup"><input class="submit-button" type="submit" value="REGISTER" style="background: green;"></a>
	    </div>
	    <div class="right">
	      <div class="content">
	        <h1>Welcome back!</h1>
	        <p>To keep connected with us <br>please login with your personal info!<br>Register now if you don't have an account!</p>
	      </div>
	    </div>
	</div>
