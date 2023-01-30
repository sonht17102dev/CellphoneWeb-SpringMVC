<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
<div class="row container">
	<div class="leftcolumn">
		<c:forEach items="${products}" var="o">
			<div class="product">
				<a href="detail_Product/${o.id}"><img
					src="${o.src}" title="${o.name}"></a>
				<h4>${o.type.toUpperCase()}</h4>
				<p>${o.name}</p>
				<span style="color: red;">
				<fmt:formatNumber type="number" groupingUsed = "true" value="${o.price}" />VND</span>
			</div>
		</c:forEach>
	</div>
	
</div>