<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit An Existing List</title>
</head>
<body>
<form action = "editClientDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type ="text" name = "listName" value=
"${listToEdit.listName}"><br />
Trip date: <input type ="text" name = "month" placeholder="mm"
size="4" value= "${month}"> <input type ="text" name = "day"
placeholder="dd" size="4" value= "${date}">, <input type ="text" name
= "year" placeholder="yyyy" size="4" value= "${year}">
Client Name: <input type = "text" name = "ClientName" value=
"${listToEdit.client.clientName}"><br />
Available Items:<br />
<select name="allCarsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCars}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.brand} |
${currentitem.model}|${currentitem.year} |
${currentitem.engine}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Cars">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>