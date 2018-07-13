

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DatastoreService datastore;
	boolean result=false;
	protected static String password,username;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		RequestDispatcher rd;
		 username = request.getParameter("uname");
		 password = request.getParameter("pword");
		
		
		
		//HttpSession s = request.getSession();
		
		  //correct password
		
		System.out.println("Username is :"+username+"Password is :"+password);
		
		try {
		 result = Entities.login_user(username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Success");
			rd=request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
		else {
			response.getWriter().println("Login Failure,Try again");
			rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
		}
	}

}
