package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanDemo1.educationalInfo;
import beanDemo1.moreInfo;

/**
 * Servlet implementation class EducationalServlet
 */
@WebServlet("/EducationalServlet")
public class EducationalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private educationalInfo eduinfo=null;
    private PrintWriter out=null; 
    private HttpSession session=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationalServlet() {
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
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		this.eduinfo=new educationalInfo();
		eduinfo.setAlgorithm(request.getParameter("algorithm"));
		eduinfo.setAndroid(request.getParameter("android"));
		eduinfo.setDatabase(request.getParameter("database"));
		eduinfo.setDatastruct(request.getParameter("datastruct"));
		eduinfo.setEnglish1(request.getParameter("english1"));
		eduinfo.setEnglish2(request.getParameter("english2"));
		eduinfo.setEnglish3(request.getParameter("english3"));
		eduinfo.setEnglish4(request.getParameter("english4"));
		eduinfo.setInternet(request.getParameter("internet"));
		eduinfo.setiOS(request.getParameter("iOS"));
		eduinfo.setMajor(request.getParameter("major"));
		eduinfo.setMath1(request.getParameter("math1"));
		eduinfo.setMath2(request.getParameter("math2"));
		eduinfo.setName(request.getParameter("name"));
		eduinfo.setNumber(request.getParameter("number"));
		eduinfo.setOs(request.getParameter("os"));
		eduinfo.setPhysical1(request.getParameter("physical1"));
		eduinfo.setPhysical2(request.getParameter("physical2"));
		eduinfo.setUsername((String) request.getSession().getAttribute("studentusername"));
		EducationalDAO dao=new EducationalDAO();
		if (!eduinfo.checkeduInfo()) {
			session.setAttribute("educationalinfo", eduinfo);
			String error = eduinfo.getErrorInfo();
			String al = "<script>alert('" + error + "')</script>";
			out.print(al);
			response.setHeader("refresh", "0;status.jsp");
		}else{
			if (dao.qurey(eduinfo.getUsername())) {
				dao.Update(eduinfo);
				session.setAttribute("educationalinfo", eduinfo);
			}else{
				if (dao.insert(eduinfo)) {
					session.setAttribute("educationalinfo", eduinfo);
				} else {
					out.println("<script>alert('用户信息保存失败,请重新保存！')</script>");
				}
			}
			response.sendRedirect("status.jsp");
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
