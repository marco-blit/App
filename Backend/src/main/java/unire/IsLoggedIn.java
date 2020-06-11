package unire;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IsLoggedIn
 */
@WebServlet("/IsLoggedIn")
public class IsLoggedIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsLoggedIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setHeader("Access-Control-Allow-Origin","*");
		HttpSession hs = request.getSession();
		PrintWriter pw = response.getWriter();

		Object o = hs.getAttribute("logged");
		if(o != null && (boolean)o)
		{
			pw.println("true");
		}
		else
		{
			pw.println("false");
		}
	}

}
