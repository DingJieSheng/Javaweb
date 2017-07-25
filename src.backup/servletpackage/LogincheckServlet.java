package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class LogincheckServlet
 */
@WebServlet("/LogincheckServlet")
public class LogincheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
	private String driverName="com.mysql.jdbc.Driver";
    private String userName="SDJ";
	private String userPassword="sdj808545365";
	private String url="jdbc:mysql://127.0.0.1:3306/webproject";
	private HttpSession session=null;
    private PrintWriter out=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogincheckServlet() {
        super();
        // TODO Auto-generated constructor stub
        try {
			Class.forName(driverName);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		out=response.getWriter();
		try {
			conn=(Connection) DriverManager.getConnection(url, userName, userPassword);
			if(request.getParameter("username").matches("^[a-zA-Z_]\\w+")&&request.getParameter("psw").matches("\\w+"))
			  {
					PreparedStatement pre=(PreparedStatement)conn. prepareStatement("select * from userInfo where username=? and psw=?;");
			    	pre.setString(1, request.getParameter("username"));
			    	pre.setString(2, request.getParameter("psw"));
			    	PreparedStatement pre1=(PreparedStatement)conn. prepareStatement("select * from managerInfo where managername=? and password=?;");
			    	pre1.setString(1, request.getParameter("username"));
			    	pre1.setString(2, request.getParameter("psw"));
			    	ResultSet resultSet=pre.executeQuery();
			    	ResultSet resultSet1=pre1.executeQuery();
			    	if(resultSet.next()){
				        session.setAttribute("userID", request.getParameter("username"));
			    	    response.sendRedirect("personInfo.jsp");
			    	}else if(resultSet1.next()){
			    		session.setAttribute("userID", request.getParameter("username"));
			    	    response.sendRedirect("manager.jsp");
			    	}else{
			    		response.sendRedirect("fail1.jsp");
			    	}
			      }
			    else
			    {
			    	response.sendRedirect("fail.jsp");
			    }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
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
