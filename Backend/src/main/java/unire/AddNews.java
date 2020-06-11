package unire;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddNews
 */
@WebServlet("/news/add")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Database db = new Database();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin","*");
		/*HttpSession hs = request.getSession();
		if((boolean) hs.getAttribute("logged"))
		{
						
		}*/
		db.AddNews(request.getParameter("title"), request.getParameter("description"), request.getParameter("image"), request.getParameter("date"));
		response.getWriter().println("true");
	}

}
