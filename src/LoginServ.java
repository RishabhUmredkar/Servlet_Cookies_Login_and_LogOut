

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServ extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("link.html");
		dispatcher.include(request, response);
		out.print("<br><hr>");

		if(pass.equals("admin123"))
		{
			out.print("You are successgully Logged In: "+name);
			
			Cookie ck = new Cookie("lname", name);
			Cookie ck1 = new Cookie("upass", name);
			response.addCookie(ck);
			response.addCookie(ck);
			
		}
		else{
			out.print("Enter correct password");

			RequestDispatcher dispatcher1 = request.getRequestDispatcher("login.html");
			dispatcher1.include(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
