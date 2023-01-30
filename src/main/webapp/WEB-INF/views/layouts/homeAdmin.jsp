<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<!-- Embed Google font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Moo+Lah+Lah&family=Redressed&family=Saira+Condensed:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Integrate bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/admin.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
</head>
<body>


	<div class="container-fluid">
		<div class="logout d-flex">
			<div>
					<a
						class="bg-transparent border-0 fw-bold text-decoration-underline"
						style='color: #ec8816;${usernameAdmin == null ? "display:none;" : ""}' href="logoutAdmin" >Logout</a>
					<a
						class="bg-transparent border-0 fw-bold text-decoration-underline"
						style='color: #ec8816;${usernameAdmin == null ? "" : "display:none;"}' href="/CellPhoneShop/admin/login">Login</a>
						
			</div>

		</div>
		<div class="row">
			<%@include file="/WEB-INF/views/layouts/admin/headerAdmin.jsp" %>

			<decorator:body />
			
			
		</div>
	</div>
</body>

	

</html>
