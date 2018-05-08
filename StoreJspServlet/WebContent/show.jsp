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
<h1>showing</h1>
<table>
<tr> 
    <th>Name</th>
    <th>Price</th> 
    <th>Qantity</th>
    <th>GoodsId</th>
</tr>
<c:forEach var="good" items="${goodslist}"> 

<tr>
    <td><c:out value="${good.goodsName}"/></td>
    <td><c:out value="${good.goodsPrice}"/></td> 
    <td><c:out value="${good.goodsQuantity}"/></td> 
    <td><c:out value="${good.goodsId}" /></td>
   
 </tr> 
</c:forEach> 
</table>
</body>
</html>