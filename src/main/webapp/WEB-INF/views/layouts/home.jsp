<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/header.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/body.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/resources/css/infoProductBody.css"/>"
	rel="stylesheet" />
	
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/login.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/signup.css"/>'>
<link href="<c:url value="/resources/css/footer.css"/>" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">	
<title>Home</title>
</head>
<body>
	
	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
	
	<decorator:body />
	
	
	<script src='<c:url value= "/resources/js/dropdown.js" />'></script>
</body>
<footer>
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
</footer>	
</html>