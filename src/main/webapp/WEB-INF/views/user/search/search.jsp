<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
<div class="row container">
		<div class="leftcolumn">
			<c:choose>
				<c:when test="${list7 != null}">
					<c:forEach items="${list7}" var="o7">
						<div class="product">
							<a href="detail_Product?id=${o7.id}"><img
								src="<c:out value="${o7.src}" />" title="<c:out value="${o7.name}" />"></a>
							<h4><c:out value="${o7.type.toUpperCase()}" /></h4>
							<p><c:out value="${o7.name}" /></p>
							<span style="color: red;">
							<fmt:formatNumber type="number" groupingUsed = "true" value="${o7.price}"/> VND</span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${list11 != null}">
					<c:forEach items="${list11}" var="o11">
						<div class="product">
							<a href="detail_Product?id=${o11.id}"><img
								src="<c:out value="${o11.src}" />" title="<c:out value="${o11.name}" />"></a>
							<h4><c:out value="${o11.type.toUpperCase()}" /></h4>
							<p><c:out value="${o11.name}" /></p>
							<span style="color: red;">
							<fmt:formatNumber type="number" groupingUsed = "true" value="${o11.price}"/> VND</span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${listX != null}">
					<c:forEach items="${listX}" var="oX">
						<div class="product">
							<a href="detail_Product?id=${oX.id}"><img
								src="<c:out value="${oX.src}" />" title="<c:out value="${oX.name}" />"></a>
							<h4><c:out value="${oX.type.toUpperCase()}" /></h4>
							<p><c:out value="${oX.name}" /></p>
							<span style="color: red;">
							<fmt:formatNumber type="number" groupingUsed = "true" value="${oX.price}"/> VND</span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${list12 != null}">
					<c:forEach items="${list12}" var="o12">
						<div class="product">
							<a href="detail_Product?id=${o12.id}"><img
								src="<c:out value="${o12.src}" />" title="<c:out value="${o12.name}" />"></a>
							<h4><c:out value="${o12.type.toUpperCase()}" /></h4>
							<p><c:out value="${o12.name}" /></p>
							<span style="color: red;">
							<fmt:formatNumber type="number" groupingUsed = "true" value="${o12.price}"/> VND</span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${list13 != null}">
					<c:forEach items="${list13}" var="o13">
						<div class="product">
							<a href="detail_Product?id=${o13.id}"><img
								src="<c:out value="${o13.src}" />" title="<c:out value="${o13.name}" />"></a>
							<h4><c:out value="${o13.type.toUpperCase()}" /></h4>
							<p><c:out value="${o13.name}" /></p>
							<span style="color: red;">
							<fmt:formatNumber type="number" groupingUsed = "true" value="${o13.price}"/> VND</span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${list14 != null}">
					<c:forEach items="${list14}" var="o14">
						<div class="product">
							<a href="detail_Product?id=${o14.id}"><img
								src="<c:out value="${o14.src}" />" title="<c:out value="${o14.name}" />"></a>
							<h4><c:out value="${o14.type.toUpperCase()}" /></h4>
							<p><c:out value="${o14.name}" /></p>
							<span style="color: red;">
							<fmt:formatNumber type="number" groupingUsed = "true" value="${o14.price}"/> VND</span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${listProduct != null}">
					<c:forEach items="${listProduct}" var="o">
						<div class="product">
						<a href="detail_Product?id=${o.id}"><img
							src="<c:out value="${o.src}" />" title="<c:out value="${o.name}" />"></a>
						<h4><c:out value="${o.type.toUpperCase()}" /></h4>
						<p><c:out value="${o.name}" /></p>
						<span style="color: red;">
						<fmt:formatNumber type="number" groupingUsed = "true" value="${o.price}"/> VND</span>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
				<p/>
				<c:set var="error" scope="session" value="${sessionScope.error}"/>
					
					${error == null ? "" : error}
				</c:otherwise>
			</c:choose>
		</div>
	</div>