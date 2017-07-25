package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanDemo1.personInfo;

/**
 * Servlet implementation class SearchServlet
 */

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private personInfo personInfo=null;
    private PrintWriter out=null; 
    private HttpSession session=null;   
    private ArrayList<personInfo> students=new ArrayList<>();

	/**
	 * @return personInfo
	 */
	public personInfo getPersonInfo() {
		return personInfo;
	}

	/**
	 * @param personInfo ÒªÉèÖÃµÄ personInfo
	 */
	public void setPersonInfo(personInfo personInfo) {
		this.personInfo = personInfo;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		this.personInfo = new personInfo();
		personInfo.setAge(request.getParameter("age"));
		personInfo.setHome(request.getParameter("home"));
		personInfo.setLocal(request.getParameter("local"));
		personInfo.setName(request.getParameter("name"));
		personInfo.setPeople(request.getParameter("people"));
		personInfo.setPhonenumber(request.getParameter("phonenumber"));
		personInfo.setSexy(request.getParameter("sexy"));
		personInfo.setStatus(request.getParameter("status"));
		personInfo.setUsername(request.getParameter("username"));
		PersonDAO dao=new PersonDAO();
		dao.itemQurey(personInfo);
		session.setAttribute("itemqurey", dao.getStudents());
		response.sendRedirect("manager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
