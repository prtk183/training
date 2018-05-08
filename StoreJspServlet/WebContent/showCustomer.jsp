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
<h1>showing Customer Data</h1>
<form action="CustomerServlet" method="get">

ID:<input type="text" name="customerId" />
Name<input type="text" name="customerName" />
Address<input type="text" name="customerAddress" />
Mode<input type="text" name="PaymentMode" />
<ol>
	<li>addCustomer[id, name, address, mode]*</li>
	<li >deleteCustomer[id]*</li>
	<li>UpdateCustomer[id, name]*</li>
	<li>ShowCustomer</li>
	
</ol>
<input type="text" name="operation" />


<input type="submit" name="submit" />

</form>
<h3>Data Table</h3>
<table>
<tr> 
    <th>customerId</th>
    <th>customerName</th> 
    <th>CustomerAddress</th>
    <th>customerMode</th>
</tr>
<c:forEach var="cot" items="${customerslist}"> 

<tr>
    <td><c:out value="${cot.customerId}"/></td>
    <td><c:out value="${cot.customerName}"/></td> 
    <td><c:out value="${cot.customerAddress}"/></td> 
    <td><c:out value="${cot.paymentMode}" /></td>
   
 </tr> 
</c:forEach> 
</table>
<form action="ToIndex" method="get">
<input type="submit" value="ToMain">
</form>
</body>
</html>