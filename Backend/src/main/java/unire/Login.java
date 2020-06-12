package unire;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Database db = new Database();
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = db.ListUsers();
		PrintWriter pw = response.getWriter();
		for(User u: users)
		{
			pw.println(u.getUsername());
			pw.println(u.getPassword());
		}
		response.setHeader("Access-Control-Allow-Origin","*");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin","*");
		boolean res = db.CheckCredentials(request.getParameter("username"), request.getParameter("password"));
		if(res)
		{
			HttpSession session = request.getSession();
			session.setAttribute("logged", true);
		}
		PrintWriter pw = response.getWriter();
		pw.println(((Boolean)res).toString());
	}

}
