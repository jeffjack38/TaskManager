package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import model.TaskManager;

@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//storing user input 
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        
        // creating new task from Task class using contructor
        Task task = new Task(0, title, description, status);
        //use addTask() method to add user's task to the TaskManager
        TaskManager.addTask(task);

        //go to task list page
        response.sendRedirect("TaskListServlet");
    }
}