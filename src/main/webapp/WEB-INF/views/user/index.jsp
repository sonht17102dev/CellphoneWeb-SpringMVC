<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div class="row container">
		<div class="pagination" >
			<ul>
				<li><a class="${(tag==null||tag==1) ? "
					hidden" : "" }" href="pagingPageProduct?index=${tag - 1}">&laquo;</a></li>
				<c:forEach begin="1" end="${endPage}" var="i">
					<li><a class='${tag == i ? "active" : ""}' href="pagingPageProduct?index=${i}">${i}</a></li>
				</c:forEach>
				<li><a class='${tag==endPage ? "hidden" : "" }' href="pagingPageProduct?index=${tag + 1}">&raquo;</a></li>
	
			</ul>
		</div>
		<div class="leftcolumn" >
				<c:forEach items="${listProduct}" var="o">
				<div class="product">
					<a href="detail_Product/${o.id}">
					<img src="${o.src}" title="${o.name}">
					</a>
					<h4><c:out value="${o.type}"/></h4>
					<p>${o.name}</p>
					<span style="color: red;"> 
					<fmt:formatNumber type="number" groupingUsed = "true" value="${o.price}" />VND</span>
				</div>
			</c:forEach>
	
		</div>

	</div>
</body>
</html>