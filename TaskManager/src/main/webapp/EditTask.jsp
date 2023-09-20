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
        <input type="hidden" name="taskId" value="${param.taskId}">
        
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${param.title}" required><br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" required>${param.description}</textarea><br><br>
        
        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="To-Do" ${param.status == 'To-Do' ? 'selected' : ''}>To-Do</option>
            <option value="In Progress" ${param.status == 'In Progress' ? 'selected' : ''}>In Progress</option>
            <option value="Completed" ${param.status == 'Completed' ? 'selected' : ''}>Completed</option>
        </select><br><br>
        
        <input type="submit" value="Update Task">
    </form>
    <br>
    <a href="TaskListServlet">Back to Task List</a>
</body>
</html>
