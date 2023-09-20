<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Task</title>
</head>
<body>
    <h1>Add New Task</h1>
    <form action="AddTaskServlet" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea><br><br>
        
        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="To-Do">To-Do</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
        </select><br><br>
        
        <input type="submit" value="Add Task">
    </form>
    <br>
    <a href="TaskListServlet">Back to Task List</a>
</body>
</html>