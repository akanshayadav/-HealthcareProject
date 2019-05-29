package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Name;

import DAO.RegistrationDAO;
import Model.RegisterUserModel;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random rand = new Random();
		int opno = (int) rand.nextInt(1000)+5000;
		System.out.println("opno "+opno+" name "+request.getParameter("name")+" type "+request.getParameter("type")+" gender "+request.getParameter("gender")+" B1 "+request.getParameter("beneficiaryone")+" b2 "+ request.getParameter("beneficiarytwo")+" address "+request.getParameter("address")+" age "+ Integer.parseInt(request.getParameter("Age")));
		RegisterUserModel reguser = new RegisterUserModel(opno, request.getParameter("name"),request.getParameter("type") , request.getParameter("gender") ,request.getParameter("beneficiaryone")  , request.getParameter("beneficiarytwo"), request.getParameter("address"),  Integer.parseInt(request.getParameter("Age")));
		String result = RegistrationDAO.RegisterUser(reguser);
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('"+result+"');");
		   out.println("location='register.jsp';");
		   out.println("</script>");
		
	}

}
