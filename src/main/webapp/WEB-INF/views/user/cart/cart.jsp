<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/user/taglib.jsp"%>
    
<div class="row justify-content-center p-3 md-2 box" >
	<c:set var="p" value="${sessionScope.cart.items}" scope="page" />
	<div style="overflow-x:auto;">
		<table class="table table-light carttable" >
			<thead>
				<th>Product in cart: ${p.size()} </th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th>Setting</th>
			</thead>
			<c:forEach var="i" items="${p}">
				<tr>
					<td><c:out value="${i.product.name}"/><br> <span>ID: <c:out value="${i.product.id}"/></span></td>
					<td><fmt:formatNumber type="number" groupingUsed = "true" value="${i.product.price}"/> VND</td>
					<td>${i.quantity}</td>
					<td><fmt:formatNumber type="number" groupingUsed = "true" value="${i.amount}"/> VND</td>
					<td>
					
					<a class="danger"
						href="${pageContext.request.contextPath}/addtocart?id=${i.product.id}&action=delete">Remove</a>
					
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="10">Total : <fmt:formatNumber type="number" 
				groupingUsed = "true" value="${sessionScope.cart.amount}"/> VND
				</td>
			</tr>
		</table>
		</div>
		<div>
		<form class="payform" action="pay" method="post">
			<label class="col-3" for="name">Customer Name</label> 
			<input class="col-6" type="text" id="name" name="name"><br> 
			<label class="col-3" for="address">Customer Address</label> 
			<input class="col-6" type="text" id="address" name="address"><br>
			<label class="col-3" for="discount">Discount code (if any) </label> 
			<input class="col-6" type="text" id="discount" name="discount"><br>
			<input type="submit" class="btn-submit center"></input>
		</form>
		</div>
	</div>