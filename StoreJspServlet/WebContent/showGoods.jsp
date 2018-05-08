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
<h1>showing Goods Data</h1>
<form action="GoodsServlet" method="get">

Id:<input type="text" name="goodsId" />
Name:<input type="text" name="goodsName" />
Quantity:<input type="text" name="goodsQuantity" />
Price:<input type="text" name="goodsPrice" />
<ol>
	<li>addGoods[id, name, quantity, price]*</li>
	<li >removeGoods[id]*</li>
	<li>UpdateGoods[id, name]*</li>
	<li>showGoods</li>
	
</ol>
<input type="text" name="operation" />


<input type="submit" name="submit" />

</form>
<h3>Data Table</h3>
<table>
<tr> 
    <th>goodsId</th>
    <th>goodsName</th> 
    <th>goodsQuantity</th>
    <th>goodsPrice</th>
</tr>
<c:forEach var="cot" items="${goodslist}"> 

<tr>
    <td><c:out value="${cot.goodsId}"/></td>
    <td><c:out value="${cot.goodsName}"/></td> 
    <td><c:out value="${cot.goodsQuantity}"/></td> 
    <td><c:out value="${cot.goodsPrice}" /></td>
   
 </tr> 
</c:forEach> 
</table>
</table>
<form action="ToIndex" method="get">
<input type="submit" value="ToMain">
</form>
</body>
</html>