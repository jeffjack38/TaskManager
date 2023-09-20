<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
</head>
<body>
    <h1>Task List</h1>
    <table>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.title}</td>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td>
                    <a href="EditTask.jsp?taskId=${task.id}">Edit</a> |
                    <a href="DeleteTaskServlet?taskId=${task.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="AddTask.jsp">Add New Task</a>
</body>
</html>