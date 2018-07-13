

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		//response.getWriter().println("<html><form><table><tr><td>Enter ID</td><td><input type = 'text' name = 'id'></td></tr>");
		//response.getWriter().println("<tr><td><input type = 'submit' value='Submit'></td></tr></table></form></html>");
		
		String i = request.getParameter("id");
		
		
		
			 
			  
			  try {
				Entities.delete(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
				  System.out.println("The record got deleted");
				  response.getWriter().println("Deleted successfully");
				  RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				  rd.include(request, response);
			 
			
				  /*System.out.println("Operation failed");
				  response.getWriter().println("Try again!!");
				  RequestDispatcher rd = request.getRequestDispatcher("/Delete.html");
				  rd.include(request, response);*/
			  
			  }

		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	


