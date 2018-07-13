import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  /**
	 * 
	 */
	
	boolean flag = false;
	boolean result = false;
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException,ServletException {
      
	RequestDispatcher rd;
	
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    /*response.getWriter().println("Registration form");

    response.getWriter().println("<html><form><table align='center'><tr><td> Name </td><td><input name='user' type ='text' ></td></tr>");
    response.getWriter().println("<tr><td>Age</td><td><input name='age' type ='text'></td></tr>");
    response.getWriter().println("<tr><td>ID</td><td><input name='id' type ='text'></td></tr>");
    response.getWriter().println("<tr><td><input value='Submit' type ='submit' ></td></tr></table></form></html>");
    
    */
    String n = request.getParameter("user");
    String a = request.getParameter("age");
    String i = request.getParameter("id");
    String p = request.getParameter("password");
    
    //Create or update entity
    try {
		 flag=Entities.kindExample_writesEntity(n,a,i,p);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    if(flag) {
    	System.out.println("Registration is success");
        response.getWriter().println("Registration is Success");    	
    	rd=request.getRequestDispatcher("/index.html");
    	try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //Retrieving an entity
   
    
    
	
	
	
	
	
	  //correct password
	
	//System.out.println("Username is :"+username+"Password is :"+password);
	




    
  
  //Delete an entity
 }
}
