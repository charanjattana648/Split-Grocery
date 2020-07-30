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
	<div class="wrap-input100 validate-input" data-validate="Name is required">
	<span class="label-input100">Bought by</span>
	<input class="input100" type="text" name="boughtBy" placeholder="Enter your name">
	<span class="focus-input100"></span>
	</div>
	
	<div class="wrap-input100 input100-select">
					<span class="label-input100">Needed Services</span>
					<div>
						<select class="selection-2" name="type">
							<option>Choose Split Type</option>
							<option value="shared">Shared</option>
							<option value="not_shared">Not Shared</option>
						</select>
					</div>
					<span class="focus-input100"></span>
				</div>
	<c:forEach var="p" items="${person}">
	<div class="wrap-input100 validate-input" data-validate="Name among grocery divided">
	<span class="label-input100">For Whom</span>
	<input class="input100" type="checkbox" value="${p.getFirstName()}"  name="forWhom" placeholder="Enter for whom">		
	<label><c:out value="${p.getFirstName()}"></c:out></label>
	<label><c:out value="${p.getLastName()}"></c:out></label>
<!-- 	<input type="checkbox" value="1" onclick="changeImage1();" /><label>Vestibular</label> -->

	<span class="focus-input100"></span>
	</div>
	</c:forEach>

<input type="submit" value="Save">
</form>

	<%-- <label><c:out value="${items.getItemName()}"></c:out></label>
	<label><c:out value="${items.getItemPrice()}"></c:out></label>	 --%>
<c:forEach var="i" items="${items}">
	<label><c:out value="${i.getId()}"></c:out></label>
	<label><c:out value="${i.getItemName()}"></c:out></label>
	<label><c:out value="${i.getItemPrice()}"></c:out></label>
	<label><c:out value="${i.getQty()}"></c:out></label>
	<label><c:out value="${i.getBoughtBy()}"></c:out></label>
	<label><c:out value="${i.getType()}"></c:out></label>
	<label><c:out value="${i.getDate()}"></c:out></label>
	


<hr>
<%-- 	<c:forEach var="person" items="${i.getForWhom()}">
	<label><c:out value="${person.getFirstName()}"></c:out></label>
	<label><c:out value="${person.getLastName()}"></c:out></label>
	</c:forEach> --%>
	<br>
</c:forEach>
</body>
</html>