package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TaskManager;

@WebServlet("/DeleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//get Id from user request
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        //call deleteTask() method from TaskManager and place user input variable, taskID
        TaskManager.deleteTask(taskId);

        //redirect to task_list from TaskListServlet
        response.sendRedirect("TaskListServlet");
    }
}