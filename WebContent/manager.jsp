<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Iterator"%>
<%@page import="servletpackage.ManagerDAO"%>
<%@page import="beanDemo1.personInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
  *{margin: 0;padding: 0;}
  td>p{font-family: 华文楷体;font-size: x-large;font-weight: bolder;color: white;}
  a>p{font-family: 华文楷体;font-size: x-large;font-weight: bolder;color: red;}
  td>input{width: 100%}
  a{text-decoration: none}
</style>
<script>
	var deletebtn = function() {
		document.getElementsByTagName("form")[0].action = "./deleteServlet";
		document.getElementsByTagName("form")[0].submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员界面</title>
</head>
<body>
     <%String user=(String)session.getAttribute("userID");
      if(user==null){
    	  %>
    	  <jsp:forward page="logout.jsp"></jsp:forward>
     <%	  
      }else{
    	  if(application.getAttribute("visitCount")==null){
    		  application.setAttribute("visitCount", 1);
    	  }else{
    		  application.setAttribute("visitCount", (Integer)application.getAttribute("visitCount")+1);
    	  }
      }
      %>
      <% 
      ArrayList<personInfo> students=null;
      if(user==null){
    	  %>
    	  <jsp:forward page="logout.jsp"></jsp:forward>
    <%	  
      }else{
    	  ManagerDAO dao=new ManagerDAO();
    	  if(dao.qureyall()){
    		  students=dao.getStudents();
    	  }
    	  if(session.getAttribute("itemqurey")!=null){
    		  students=(ArrayList<personInfo>)session.getAttribute("itemqurey");
    		  session.removeAttribute("itemqurey");
    	  }
      }
      %>
    <div style="background-color: black;width:100%;height: 20px;text-align: center;margin: 0;padding: 0;position: relative;" >
		<p style="color:white;float: left"><%=user %></p>
        <p style="color: white;float: right"><a href="logout.jsp" style="color: white;">退出</a></p>
	</div>
	<div align="center" style="position: absolute;bottom: 0px;top: 20px;width: 100%;background: url(res/bg3.jpg);background-repeat: no-repeat;background-position: center;background-size: cover">
	     <table align="center" border="2" bordercolor="white" style="text-align: center">
	              <tr>
	                 <th colspan="9"><font face="华文楷体" color="white" size="10px">学生信息</font></th>
	              </tr>
	              <tr>
	                 <td><p>用户名</p></td>
	                 <td><p>姓名</p></td>
	                 <td><p>年龄</p></td>
	                 <td><p>籍贯</p></td>
	                 <td><p>民族</p></td>
	                 <td><p>性别</p></td>
	                 <td><p>政治面貌</p></td>
	                 <td><p>住址</p></td>
	                 <td><p>联系电话</p></td>
	               </tr>
	         <% if(students!=null){
	               Iterator iter=students.iterator();
	               while(iter.hasNext()){
	            	    personInfo person=(personInfo)iter.next();
	             %>
	              <tr>
	                 <td><a href=<%=this.getServletContext().getContextPath()+"/managerServlet?studentusername="+person.getUsername()%> target="_blank" ><p><%=person.getUsername()!=null?person.getUsername():""%></p></a></td>
	                 <td><p ><%=person.getName()!=null?person.getName():""%></p></td>
	                 <td><p ><%=person.getAge()!=null?person.getAge():""%></p></td>
	                 <td><p ><%=person.getLocal()!=null?person.getLocal():""%></p></td>
	                 <td><p ><%=person.getPeople()!=null?person.getPeople():""%></p></td>
	                 <td><p ><%=person.getSexy()!=null?person.getSexy():""%></p></td>
	                 <td><p ><%=person.getStatus()!=null?person.getStatus():""%></p></td>
	                 <td><p ><%=person.getHome()!=null?person.getHome():""%></p></td>
	                 <td><p><%=person.getPhonenumber()!=null?person.getPhonenumber():""%></p></td>
	              </tr>
	              <%
	              }
	           }%>
	     </table>
	     <form action=<%=this.getServletContext().getContextPath()+"/searchServlet"%> target="_self" method="get" style="position:absolute;bottom:0px;">
	           <table align="center" border="2" bordercolor="white" style="text-align: center;margin: 0 auto;">
	              <tr>
	                 <th colspan="9"><font face="华文楷体" color="white" size="5px">查询信息</font></th>
	              </tr>
	              <tr>
	                 <td><p>用户名</p></td>
	                 <td><p>姓名</p></td>
	                 <td><p>年龄</p></td>
	                 <td><p>籍贯</p></td>
	                 <td><p>民族</p></td>
	                 <td><p>性别</p></td>
	                 <td><p>政治面貌</p></td>
	                 <td><p>住址</p></td>
	                 <td><p>联系电话</p></td>
	              </tr>
	              <tr>
	                 <td><input type="text" name="username"></td>
	                 <td><input type="text" name="name" ></td>
	                 <td><input type="text" name="age" ></td>
	                 <td><input type="text" name="local" ></td>
	                 <td><input type="text" name="people" ></td>
	                 <td><input type="text" name="sexy" ></td>
	                 <td><input type="text" name="status" ></td>
	                 <td><input type="text" name="home" ></td>
	                 <td><input type="text" name="phonenumber" ></td>
	              </tr>
	           </table>
	           <input type="submit" value="查询" style="font-family: 华文楷体;font-size: large;font-weight: bold;" align="center">
	           <input type="button" value="删除" style="font-family: 华文楷体;font-size: large;font-weight: bold;" align="center" onclick="deletebtn()">
	     </form>
	</div>
</body>
</html>