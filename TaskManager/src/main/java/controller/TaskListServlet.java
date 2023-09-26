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

	public TaskListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddTaskHelper dao = new AddTaskHelper();

		request.setAttribute("allTasks", dao.showAllTasks());

		String path = "/task_list.jsp";

		if (dao.showAllTasks().isEmpty()) {
			// if there is nothing in the list, redirect the user to the index to add a task
			path = "/index.html";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
