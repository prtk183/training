<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Goods" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>showing Supplier Data</h1>
<form action="SupplierssServlet" method="get">

ID:<input type="text" name="supplierId" />
Name:<input type="text" name="supplierName" />
Address<input type="text" name="supplierAddress" />
QuantityOrder<input type="text" name="quantityOrder" />
OrderId<input type="text" name="orderId" />
amount<input type="text" name="amount" />

<ol>
	<li>addSupplier[all]*</li>
	<li >removeSupplier[id]*</li>
	<li>updatesupplier[id, name]*</li>
	<li>showSupplier</li>
	
</ol>
<input type="text" name="operation" />


<input type="submit" name="submit" />

</form>
<h3>Data Table</h3>
<table>
<tr> 
    <th>supplierId</th>
    <th>supplierName</th> 
    <th>supplierAddress</th>
    <th>supplierOrder</th>
	<th>supplierOrderId</th>
	<th>supplierAmount</th>
	
</tr>
<c:forEach var="cot" items="${supplierslist}"> 

<tr>
    <td><c:out value="${cot.supplierId}"/></td>
    <td><c:out value="${cot.supplierName}"/></td> 
    <td><c:out value="${cot.supplierAddress}"/></td> 
    <td><c:out value="${cot.quantityOrder}" /></td>
    <td><c:out value="${cot.orderId}" /></td>
    <td><c:out value="${cot.amount}" /></td>
   
 </tr> 
</c:forEach> 
</table>
</table>
<form action="ToIndex" method="get">
<input type="submit" value="ToMain">
</form>
</body>
</html>