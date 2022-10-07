<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allCars}" var="currentitem">
<tr>
 <td><input type="radio" name="id" value="${currentitem.id}"></td>
 <td>${currentitem.brand}</td>
 <td>${currentitem.model}</td>
 <td>${currentitem.year}</td>
 <td>${currentitem.engine}</td>
 </tr>
</c:forEach>
</table>

<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>