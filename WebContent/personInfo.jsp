<%@page import="beanDemo1.personInfo" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
				pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
<style type="text/css">
  *{margin: 0;padding: 0;}
  td>p{font-family: 华文楷体;font-size: x-large;font-weight: bolder;color: white;}
</style>
</head>
<body style="margin: 0;padding: 0;">
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
    <jsp:useBean scope="session" id="person" class="beanDemo1.personInfo"/>
    <%person=(personInfo)session.getAttribute("personinfo");
    if(person==null){
    	person=new personInfo();
    }
    if(person.getUsername()!=null){
    	session.setAttribute("studentusername", person.getUsername());
    }
    %>
	<div style="background-color: black;width:100%;height: 20px;text-align: center;margin: 0;padding: 0;position: relative;" >
		<p style="color:white;float: left"><%=user %></p>
        <p style="color: white;float: right"><a href="logout.jsp" style="color: white;">退出</a></p>
	</div>
	<div align="center" style="position: absolute;bottom: 20px;top: 20px;width: 100%;background: url(res/bg3.jpg);background-repeat: no-repeat;background-position: center;background-size: cover">
	     <form action=<%=this.getServletContext().getContextPath()+"/personInfoServlet"%> target="_self" method="get">
	           <table >
	              <tr>
	                 <th colspan="4"><font face="华文楷体" color="white" size="10px">个人信息</font></th>
	              </tr>
	              <tr>
	                 <td><p>姓名</p></td>
	                 <td><input type="text" name="name" value="<%=person.getName()!=null?person.getName():""%>"></td>
	                 <td><p>年龄</p></td>
	                 <td><input type="text" name="age" value="<%=person.getAge()!=null?person.getAge():""%>"></td>
	              </tr>
	              <tr>
	                 <td><p>籍贯</p></td>
	                 <td><input type="text" name="local" value="<%=person.getLocal()!=null?person.getLocal():""%>"></td>
	                 <td><p>民族</p></td>
	                 <td><input type="text" name="people" value="<%=person.getPeople()!=null?person.getPeople():""%>"></td>
	              </tr>
	              <tr>
	                 <td><p>性别</p></td>
	                 <td><input type="text" name="sexy" value="<%=person.getSexy()!=null?person.getSexy():""%>"></td>
	                 <td><p>政治面貌</p></td>
	                 <td><input type="text" name="status" value="<%=person.getStatus()!=null?person.getStatus():""%>"></td>
	              </tr>
	              <tr>
	                 <td><p>住址</p></td>
	                 <td><input type="text" name="home" value="<%=person.getHome()!=null?person.getHome():""%>"></td>
	                 <td><p>联系电话</p></td>
	                 <td><input type="text" name="phonenumber" value="<%=person.getPhonenumber()!=null?person.getPhonenumber():""%>"></td>
	              </tr>
	           </table>
	           <input type="submit" value="保存" style="font-family: 华文楷体;font-size: large;font-weight: bold;">
	     </form>
	</div>
    <div style="background-color: black;text-align: center;margin: 0;padding: 0;width: 100%;height: 20px;bottom: 0px;position: absolute; ">
        <p style="color:white;"><%="网站访问人次数："+application.getAttribute("visitCount") %></p>
    </div>
</body>
</html>