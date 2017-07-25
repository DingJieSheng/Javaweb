package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanDemo1.personInfo;

/**
 * Servlet implementation class ManagerServlet
 */

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private personInfo personInfo=null;
    private PrintWriter out=null; 
    private HttpSession session=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		out=response.getWriter();
		session=request.getSession();
		response.setCharacterEncoding("GBK");
//		request.setCharacterEncoding("gbk");
//		response.setCharacterEncoding("gbk");
		this.personInfo=new personInfo();
		PersonDAO dao=new PersonDAO();
		if(dao.qurey(request.getParameter("studentusername"))){
			session.setAttribute("studentusername",request.getParameter("studentusername"));
			personInfo=dao.getPinfo();
			session.setAttribute("personinfo", personInfo);
			session.setAttribute("power", 1);
			RequestDispatcher re=request.getRequestDispatcher("./personInfoServlet");
			re.forward(request, response);
		}else{
			String error = "未查询到有关信息，请重新操作！";
			String al = "<script>alert('" + error + "')</script>";
			out.print(al);
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
