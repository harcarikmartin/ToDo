package servlet;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Note;

/**
 * Servlet implementation class ToDoListServlet
 */
@WebServlet("/ToDoListServlet")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer, Note> list = new HashMap<Integer, Note>();
	int i;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(list.isEmpty()) {
			i = 0;
		}
		if("addTask".equals(action) 
				&& !request.getParameter("taskName").isEmpty() 
				&& !request.getParameter("taskBody").isEmpty()) {
			list.put(++i, new Note(i, request.getParameter("taskName").trim(), request.getParameter("taskBody").trim()));
//			System.out.println(list);
		} else if("removeCompletedTasks".equals(action) && request.getParameter("toDelete") != null) {
			String[] ids = request.getParameterValues("toDelete");
			for(String id:ids) {
				list.values().remove(list.get(Integer.parseInt(id)));
			}
		}
		forwardToList(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void forwardToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("date", new Date().toString());
		request.setAttribute("list", list.values());
		request.getRequestDispatcher("/WEB-INF/jsp/toDoList.jsp").forward(request, response);
	}
}
