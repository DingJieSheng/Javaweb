<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <%String user=(String)session.getAttribute("userID");
      if(user==null){
    	  %>
    	  <jsp:forward page="logout.jsp"></jsp:forward>
    <%	  
      }
      %>
      <jsp:useBean scope="session" id="eduInfo" class="beanDemo1.educationalInfo"/>
      <jsp:setProperty property="*" name="eduInfo"/>
      <%if(!eduInfo.checkeduInfo()){
    	  String error=eduInfo.getErrorInfo();
    	  String al="<script>alert('"+error+"')</script>";
    	  out.print(al);
    	  response.setHeader("refresh", "0;status.jsp");
      }else{
    	  response.setHeader("refresh", "0;status.jsp");
      }
      %>

</body>
</html>