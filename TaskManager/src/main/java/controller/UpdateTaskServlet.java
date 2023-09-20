package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;
import model.TaskManager;

@WebServlet("/UpdateTaskServlet")
public class UpdateTaskServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//get updated user input from request
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        
        //Create an new updated task with the details from user
        Task updatedTask = new Task(taskId, title, description, status);
        //update in TaskManager updateTask()
        TaskManager.updateTask(updatedTask);

        //redirect to task_list from TaskListServlet
        response.sendRedirect("TaskListServlet");
    }
}
