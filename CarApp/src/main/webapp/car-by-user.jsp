<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Cars</title>
</head>
<body>
<form method = "post" action = "listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
 <td><input type="radio" name="id" value="${currentlist.id}"></td>
 <td><h2>${currentlist.listName}</h2></td></tr>
 <tr><td colspan="3">Trip Date: ${currentlist.tripDate}</td></tr>
 <tr><td colspan="3">Client:
${currentlist.Client.ClientName}</td></tr>
 <c:forEach var = "listVal" items = "${currentlist.listOfCars}">
 <tr><td></td><td colspan="3">
 ${listVal.brand}, ${listVal.model},${listVal.year}, ${listVal.engine}

 </td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<a href="createNewListServlet">Create a new List</a></br>
<a href="index.html">Insert a new item</a></br>
</body>
</html>