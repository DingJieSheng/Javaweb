package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanDemo1.moreInfo;
import beanDemo1.personInfo;

public class MoreinfoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private moreInfo minfo=null;
    private PrintWriter out=null; 
    private HttpSession session=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoreinfoServlet() {
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
		this.minfo=new moreInfo();
		minfo.setUsername((String) request.getSession().getAttribute("studentusername"));
		minfo.setBirth(request.getParameter("birth"));
		minfo.setCollege(request.getParameter("college"));
		minfo.setEducation(request.getParameter("education"));
		minfo.setHealth(request.getParameter("health"));
		minfo.setHobby(request.getParameter("hobby"));
		minfo.setLength(request.getParameter("length"));
		minfo.setMajor(request.getParameter("major"));
		minfo.setMarry(request.getParameter("marry"));
		minfo.setNumber(request.getParameter("number"));
		minfo.setWeight(request.getParameter("weight"));
		MoreinfoDAO dao=new MoreinfoDAO();
		if (!minfo.checkMore()) {
			session.setAttribute("moreinfo", minfo);
			String error = minfo.getErrorInfo();
			String al = "<script>alert('" + error + "')</script>";
			out.print(al);
			response.setHeader("refresh", "0;status.jsp");
		}else{
			if (dao.qurey(minfo.getUsername())) {
				dao.Update(minfo);
				session.setAttribute("moreinfo", minfo);
			}else{
				if (dao.insert(minfo)) {
					session.setAttribute("moreinfo", minfo);
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
