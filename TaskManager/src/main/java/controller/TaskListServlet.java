package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import model.TaskManager;

@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//store user input into List<Task> and use getAllTasks() method from TaskManager class to get all user input
        List<Task> tasks = TaskManager.getAllTasks();
        //set tasks as an attribute for rendering in JSP
        request.setAttribute("tasks", tasks);
        
        //forward the request to the task list JSP page for rendering
        request.getRequestDispatcher("task_list.jsp").forward(request, response);
    }
}
