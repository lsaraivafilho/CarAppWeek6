: <%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editCarServlet" method="post">
Brand: <input type ="text" name = "brand" value= "${itemToEdit.brand}">
Model: <input type = "text" name = "model" value= "${itemToEdit.model}">
Year: <input type = "text" name = "year" value= "${itemToEdit.year}">
Engine: <input type = "text" name = "engine" value= "${itemToEdit.engine}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>