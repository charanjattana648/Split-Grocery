<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Welcome to Items</h1>

<form action="addPerson" method="post" modelAttribute="person">
	<div class="wrap-input100 validate-input" data-validate="Person FirstName is required">
	<span class="label-input100">FirstName</span>
	<input class="input100" type="text" name="firstName" placeholder="Enter FirstName">
	<span class="focus-input100"></span>
	</div>
	<div class="wrap-input100 validate-input" data-validate="Person LastName is required">
	<span class="label-input100">LastName</span>
	<input class="input100" type="text" name="lastName" placeholder="Enter LastName">
	<span class="focus-input100"></span>
	</div>
	
	<input type="submit" value="Save">
</form>
<c:forEach var="p" items="${person}">
<label><c:out value="${p.getFirstName()}"></c:out></label>
<label><c:out value="${p.getLastName()}"></c:out></label>
</c:forEach>
<hr>
<form action="addItem" method="post" modelAttribute="item">
<!-- //<input type="text" name="itemName"> -->
	<div class="wrap-input100 validate-input" data-validate="Item Name is required">
	<span class="label-input100">Item Name</span>
	<input class="input100" type="text" name="itemName" placeholder="Enter item name">
	<span class="focus-input100"></span>
	</div>
	<div class="wrap-input100 validate-input" data-validate="Item qty is required">
	<span class="label-input100">Item Quantity</span>
	<input class="input100" type="text" name="qty" placeholder="Enter item qty">
	<span class="focus-input100"></span>
	</div>
	<div class="wrap-input100 validate-input" data-validate="Price is required">
	<span class="label-input100">Item Price</span>
	<input class="input100" type="text" name="itemPrice" placeholder="Enter item price">
	<span class="focus-input100"></span>
	</div>
	<!-- <div class="wrap-input100 validate-input" data-validate="Name is required">
	<span class="label-input100">Bought by</span>
	<input class="input100" type="text" name="boughtBy" placeholder="Enter your name">
	<span class="focus-input100"></span>
	</div> -->
	
	<div class="wrap-input100 input100-select">
					<span class="label-input100">Bought by</span>
					
						<select class="selection-2" name="boughtBy">
							<!-- <option>Bought by</option> -->
								<c:forEach var="p" items="${person}">
							<option value="${p.getFirstName()} ${p.getLastName()}">
								<label><c:out value="${p.getFirstName()}"></c:out></label>
								<label><c:out value="${p.getLastName()}"></c:out></label>
							</option>
							</c:forEach>
						</select>
					
					<span class="focus-input100"></span>
				</div>
	
	<!-- <div class="wrap-input100 input100-select">
					<span class="label-input100">Choose Split Type</span>
					
						<select class="selection-2" name="type">
							<option value="shared_among">Shared among</option>
							<option value="totally_for">Totally for</option>
							<option value="partially_shared_for">Partially shared for</option>
						</select>
					
					<span class="focus-input100"></span>
				</div> -->
	
	<div class="wrap-input100 validate-input" data-validate="Name among grocery divided">
	<span class="label-input100">For Whom</span>
	<c:forEach var="p" items="${person}">
	<input class="input100" type="checkbox" value="${p.getFirstName()} ${p.getLastName()}"  name="forWhom" placeholder="Enter for whom">		
	<label><c:out value="${p.getFirstName()}"></c:out></label>
	<label><c:out value="${p.getLastName()}"></c:out></label><br>
<!-- 	<input type="checkbox" value="1" onclick="changeImage1();" /><label>Vestibular</label> -->
	</c:forEach>
	<span class="focus-input100"></span>
	</div>


<input type="submit" value="Save">
</form>
<table>

	<%-- <label><c:out value="${items.getItemName()}"></c:out></label>
	<label><c:out value="${items.getItemPrice()}"></c:out></label>	 --%>
	<thead><tr><th>Item Id</th><th>Item Name</th><th>Item Price</th><th>Item Quantity</th><th>Item Bought By</th><th>Item Type</th><th>For Whom</th><th>Date</th><th>Edit</th></tr></thead>
<c:forEach var="i" items="${items}">
<tr>
	<td><label><c:out value="${i.getId()}"></c:out></label></td>
	<td><label><c:out value="${i.getItemName()}"></c:out></label></td>
	<td><label><c:out value="${i.getItemPrice()}"></c:out></label></td>
	<td><label><c:out value="${i.getQty()}"></c:out></label></td>
	<td><label><c:out value="${i.getBoughtBy()}"></c:out></label></td>
	<td><label><c:out value="${i.getType()}"></c:out></label></td>
	<td><c:forEach var="person" items="${i.getForWhom()}">
	<label><c:out value="${person}"></c:out></label>
	</c:forEach></td>	
	<td><label><c:out value="${i.getDate()}"></c:out></label></td>
	<td><a href="#">Remove</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>