

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/profile")
public class ProfileServ extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		out.print("<br><hr>");
		Cookie ck[] = request.getCookies();
		if(ck!=null)
		{

			String name = ck[0].getValue();
			
			if(!name.equals("")|| name!=null)
			{
				out.print("Welcome to the Profile <br>");
				out.print("Hello " +name);
			}
		}else{
			out.print("<p style='color:red;'>Please login First</p>");

			request.getRequestDispatcher("login.html").include(request, response);
		}

	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
