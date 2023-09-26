<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
</head>
<body>
    <h1>My Task List</h1>
    <form method = "post" action = "NavigationServlet">
    <table>
        <c:forEach items="${requestScope.allTasks}" var="currentTask">
        <tr>
        	<td><input type="radio" name="id" value="${currentTask.id}" ></td>
        	<td>${currentTask.title}</td>
        	<td>${currentTask.description}</td>
        	<td>${currentTask.status}</td>
        </tr>
        </c:forEach>
    </table>
    <br />
    <input type = "submit" value = "edit" name="doThisToTask">
    <input type = "submit" value = "delete" name="doThisToTask">
    <input type = "submit" value = "add" name="doThisToTask">
    </form>
</body>
</html>