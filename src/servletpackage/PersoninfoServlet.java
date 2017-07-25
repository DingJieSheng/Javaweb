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
import beanDemo1.personInfo;

/**
 * Servlet implementation class PersoninfoServlet
 */

public class PersoninfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private personInfo personInfo=null;
    private PrintWriter out=null; 
    private HttpSession session=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersoninfoServlet() {
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
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
//		request.setCharacterEncoding("gbk");
//		response.setCharacterEncoding("gbk");
		this.personInfo=(personInfo)session.getAttribute("personinfo");
		if (personInfo==null) {
			this.personInfo = new personInfo();
			personInfo.setAge(request.getParameter("age"));
			personInfo.setHome(request.getParameter("home"));
			personInfo.setLocal(request.getParameter("local"));
			personInfo.setName(request.getParameter("name"));
			personInfo.setPeople(request.getParameter("people"));
			personInfo.setPhonenumber(request.getParameter("phonenumber"));
			personInfo.setSexy(request.getParameter("sexy"));
			personInfo.setStatus(request.getParameter("status"));
			personInfo.setUsername((String) session.getAttribute(
					"studentusername")==null?(String) session.getAttribute(
							"userID"):(String) session.getAttribute(
									"studentusername"));
		}
		if (!personInfo.checkInfo()) {
			session.setAttribute("personinfo", personInfo);
			String error = personInfo.getErrorInfo();
			String al = "<script>alert('" + error + "')</script>";
			out.print(al);
			response.setHeader("refresh", "0;personInfo.jsp");
		}else{
			PersonDAO dao=new PersonDAO();
			if (dao.qurey(personInfo.getUsername())) {
				dao.Update(personInfo);
				MoreinfoDAO dao2=new MoreinfoDAO();
				EducationalDAO dao3=new EducationalDAO();
				moreInfo minfo=new moreInfo();
				educationalInfo eduinfo=new educationalInfo();
				if(dao2.qurey(personInfo.getUsername())){
					minfo=dao2.getMinfo();
				}
				if(dao3.qurey(personInfo.getUsername())){
					eduinfo=dao3.getEduinfo();
				}
				session.setAttribute("personinfo", personInfo);
				session.setAttribute("moreinfo", minfo);
				session.setAttribute("educationalinfo", eduinfo);
				if(session.getAttribute("power")!=null&&(int)session.getAttribute("power")==1){
				}else{
					session.setAttribute("power", 0);
				}
				response.sendRedirect("status.jsp");
			}else{
				if (dao.insert(personInfo)) {
					session.setAttribute("personinfo", personInfo);
					if(session.getAttribute("power")!=null&&(int)session.getAttribute("power")==1){
					}else{
						session.setAttribute("power", 0);
					}
					response.sendRedirect("status.jsp");
				} else {
					out.println("<script>alert('用户信息保存失败,请重新保存！')</script>");
					response.setHeader("refresh", "0;personInfo.jsp");
				}
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
