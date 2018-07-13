

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet(

	name = "update_Servlet",
	urlPatterns= {"/update"}
)
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	boolean f;
    public update() {
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
		    response.setCharacterEncoding("UTF-8");

		   // response.getWriter().println("Update form");


		   /* response.getWriter().println("<html><form><table align='center'><tr><td>UpdatedName </td><td><input name='user' type ='text' ></td></tr>");
		    response.getWriter().println("<tr><td>Updated Age</td><td><input name='age' type ='text'></td></tr>");
		    response.getWriter().println("<tr><td>ID</td><td><input name='id' type ='text'></td></tr>");
		    response.getWriter().println("<tr><td><input value='Submit' type ='submit' ></td></tr></table></form></html>");*/
		    
		    
		    String n = request.getParameter("user");
		    String a = request.getParameter("age");
		    String i = request.getParameter("id");
		    String p = request.getParameter("password");
		    
		   
		    try {
				f=Entities.kindExample_writesEntity(n,a,i,p);
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    if(f) {
		    	System.out.println("Update is success");
		        response.getWriter().println("Updated  Successfully");    	
		    	RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		    	try {
					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    
		  // doPost(request,response);
	
	}
	
	/*public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      //doGet(request, response);
		      
		      if (f) {
		      RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			    rd.forward(request,response);
		      }
		   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
