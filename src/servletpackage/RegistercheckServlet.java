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

import beanDemo1.managerInfo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class RegistercheckServlet extends HttpServlet {
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
    public RegistercheckServlet() {
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
		session = request.getSession();
		out = response.getWriter();
		try {
			conn = (Connection) DriverManager.getConnection(url, userName,
					userPassword);
			if (request.getParameter("username").matches("^[a-zA-Z_]\\w+")
					&& request.getParameter("psw").matches("\\w+")&&request.getParameter("psw").equals(request.getParameter("psw1"))) {
				PersonDAO dao=new PersonDAO();
				ManagerDAO dao2=new ManagerDAO();
				boolean flag1=dao.qurey(request.getParameter("username"));
				boolean flag2=dao2.qurey(request.getParameter("username"));
				if (!flag1&&!flag2) {
					if (request.getParameter("type").equals("普通用户")) {
						PreparedStatement pre2 = (PreparedStatement) conn
								.prepareStatement("insert into userInfo(username,psw)values(?,?);");
						pre2.setString(1, request.getParameter("username"));
						pre2.setString(2, request.getParameter("psw"));
						pre2.execute();
						session.setAttribute("userID",
								request.getParameter("username"));
						response.sendRedirect("personInfo.jsp");
					} else {
						managerInfo info=new managerInfo();
						info.setName(request.getParameter("username"));
						info.setPsw(request.getParameter("psw"));
						dao2.insert(info);
						session.setAttribute("userID",
								request.getParameter("username"));
						response.sendRedirect("manager.jsp");
					}
				} else {
					response.sendRedirect("registerfail.jsp");
				}
			} else {
				response.sendRedirect("registerfail1.jsp");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
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
	}

}
