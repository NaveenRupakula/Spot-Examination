

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class student_register_servlet
 */
@WebServlet("/student_register_servlet")
public class student_register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 try {
			    Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			    PreparedStatement ps = con.prepareStatement("insert into studenttable values(?,?,?,?,?)");
			    String studentName = request.getParameter("r1");
			    String studentId = request.getParameter("r2");
			    String mobileNumber = request.getParameter("r3");
			    String institutionId = request.getParameter("r4");
			    String password = request.getParameter("r5");
			    ps.setString(1, studentName);
			    ps.setString(2, studentId);
			    ps.setString(3, mobileNumber);
			    ps.setString(4, institutionId);
			    ps.setString(5, password);
			    ps.executeUpdate();
			    response.setContentType("text/html");
			    
			    response.sendRedirect("student_login.html");
			    }
			    
			    catch(Exception e) {
			      System.out.println(e);
			    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
