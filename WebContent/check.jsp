<%@page import="javafx.scene.control.Alert"%>
<%@ page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>验证界面</title>
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
    	if(request.getParameter("psw").equals(request.getParameter("psw1"))){
    		PreparedStatement pre=(PreparedStatement)conn. prepareStatement("select * from userInfo where username=?;");
        	pre.setString(1, request.getParameter("username"));
        	ResultSet resultSet=pre.executeQuery();
        	if(!resultSet.next()){
        		pre=(PreparedStatement)conn. prepareStatement("insert into userInfo(username,psw)values(?,?);");
    	        pre.setString(1, request.getParameter("username"));
    	        pre.setString(2, request.getParameter("psw"));
    	        pre.execute();
    	        session.setAttribute("userID", request.getParameter("username"));
    %>
    	    <jsp:forward page="personInfo.jsp"></jsp:forward>
    <% 
    	}
        else{%>
        	<%out.print("<script>alert('用户名已存在！')</script>"); %>
        	<%response.setHeader("refresh","0;./register.jsp");%>
    <%      }
    	}else{
    		%>
    		<%out.print("<script>alert('两次密码输入不一致，请重新输入！')</script>"); %>
    		<%response.setHeader("refresh", "0;register.jsp");%>
    <% 
    	}
    	conn.close();
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