


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

/**
 * Servlet implementation class retrieve
 */
@WebServlet("/retrieve")
public class retrieve extends Login {
	private static final long serialVersionUID = 1L;
       RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
   public retrieve() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		
		
		String i = request.getParameter("id");
		System.out.println("Password is :"+Login.password);
		
		try {
		Entity e4 = Entities.retrieve(i);
		System.out.println("retrieved password :"+e4.getProperty("Pin"));
		System.out.println("Stored Password :"+Login.password);
		String pw = e4.getProperty("Pin").toString();
		System.out.println("Pw is :"+ pw);
		//boolean v = (pw == "1111");
		//System.out.println(v);//checking the login passwords with the retrieved one  
		if(pw.equals(Login.password) ||(Login.password.equals("admin123") && (Login.username.equals("administrator"))) )
		{
		
			
	    response.getWriter().println("<html>"
	    		+ "<style>\r\n" + 
	    		".center {\r\n" + 
	    		"    padding: 70px 0;\r\n" + 
	    		"    \r\n" + 
	    		"    text-align: center;\r\n" + 
	    		"}\r\n" + 
	    		"</style><body style=\"background-image:url('BG-1.jpg')\">");
	   // response.getWriter().println("<table align = 'center'>");
	    response.getWriter().println("<div class = 'center'>");
		response.getWriter().println("<b>The details are as follows::</b><br>");
		// response.getWriter().println("<tr><td>");
		response.getWriter().println("Name :"+e4.getProperty("Name"));
	    //response.getWriter().println("\n");
		//response.getWriter().println("</tr></td>");
		//response.getWriter().println("<tr><td>");
		response.getWriter().println("Age :"+e4.getProperty("Age"));
		//response.getWriter().println("</tr></td>");
		response.getWriter().println("</div></body></html>");
			//rd = request.getRequestDispatcher("display.jsp");
			//rd.include(request, response);
		}
		else
		{
			response.getWriter().println("You are not an authorised person , use your id  ");
			rd = request.getRequestDispatcher("/Retrieve.html");
			rd.include(request, response);
			
		}
		}catch(NullPointerException e) {
			System.out.print(e);
		}
		
		//response.getWriter().println("Name :"+e4.getProperty("Name"));
		//System.out.println(Name);
	}

}
