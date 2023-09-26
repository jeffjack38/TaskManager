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
	
	public AddTaskServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//storing user input 
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        
        if (title.isEmpty() || description.isEmpty() || status.isEmpty() || title == null || description == null || status == null) {
        	getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        } else {
        	Task task = new Task(title, description, status);
        	AddTaskHelper dao = new AddTaskHelper();
        	dao.insertItem(task);
        	
        	getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        }
        
    }
}