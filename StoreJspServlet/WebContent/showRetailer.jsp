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
<h1>showing Retailer Data</h1>
<form action="CustomersView" method="get">


<input type="submit" value="View Customer" />

</form>
<form action="SuppliersView" method="get">


<input type="submit" value="View Suppliers" />

</form>
<form action="GoodsView" method="get">


<input type="submit" value="View Goods" />

</form>
<h3>Data Table</h3>
<table>
<tr> 
    <th>reatilerId</th>
    <th>retailerName</th> 
    <th>retailerAddress</th>
</tr>
<c:forEach var="cot" items="${retailerslist}"> 

<tr>
    <td><c:out value="${cot.retailerId}"/></td>
    <td><c:out value="${cot.retailerName}"/></td> 
    <td><c:out value="${cot.retailerAddres}"/></td> 
   
 </tr> 
</c:forEach> 
</table>
</table>
<form action="ToIndex" method="get">
<input type="submit" value="ToMain">
</form>
</body>
</html>