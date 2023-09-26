<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
    <h1>Edit Task</h1>
    <form action="UpdateTaskServlet" method="post">
        
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${taskToUpdate.title}" required><br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" required>${taskToUpdate.description}</textarea><br><br>
        
        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="To-Do" ${taskToUpdate.status == 'To-Do' ? 'selected' : ''}>To-Do</option>
            <option value="In Progress" ${taskToUpdate.status == 'In Progress' ? 'selected' : ''}>In Progress</option>
            <option value="Completed" ${taskToUpdate.status == 'Completed' ? 'selected' : ''}>Completed</option>
        </select><br><br>
        <input type = "hidden" name = "id" value = "${taskToUpdate.id}">
        <input type="submit" value="Update Task">
    </form>
    <br>
    <a href="TaskListServlet">Back to Task List</a>
</body>
</html>
