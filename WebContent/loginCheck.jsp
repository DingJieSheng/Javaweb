<%@page import="javafx.scene.control.Alert"%>
<%@ page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录检测</title>
</head>
<body>
     <%Connection conn=null;
	  String driverName="com.mysql.jdbc.Driver";
      String userName="SDJ";
	  String userPassword="sdj808545365";
	  String url="jdbc:mysql://127.0.0.1:3306/webproject"; %>
	<%Class.forName(driverName);
	  conn=DriverManager.getConnection(url, userName, userPassword);%>
    <%if(request.getParameter("username").matches("^[0-9a-zA-Z]\\w+")&&request.getParameter("psw").matches("\\w+"))
      {
    		PreparedStatement pre=(PreparedStatement)conn. prepareStatement("select * from userInfo where username=? and psw=?;");
        	pre.setString(1, request.getParameter("username"));
        	pre.setString(2, request.getParameter("psw"));
        	PreparedStatement pre1=(PreparedStatement)conn. prepareStatement("select * from managerInfo where username=? and psw=?;");
        	pre1.setString(1, request.getParameter("username"));
        	pre1.setString(2, request.getParameter("psw"));
        	ResultSet resultSet=pre.executeQuery();
        	ResultSet resultSet1=pre1.executeQuery();
        	if(resultSet.next()){
    	        session.setAttribute("userID", request.getParameter("username"));
    	        conn.close();
    %>
    	    <jsp:forward page="personInfo.jsp"></jsp:forward>
    <%      
    	}else if(resultSet1.next()){
    		session.setAttribute("userID", request.getParameter("username"));
	        conn.close();
	        %>
    	    <jsp:forward page="manager.jsp"></jsp:forward>
    <%
    	}else{
    		conn.close();
    		%>
    		<%out.print("<script>alert('输入不正确，请重新输入或注册新用户！')</script>"); %>
            <%response.setHeader("refresh", "0;login.jsp"); %>
    <% 
    	}
      }
    else
    {
    	conn.close();
    %>
        <jsp:forward page="fail.jsp"></jsp:forward>
    <%
    }
    %>

</body>
</html>