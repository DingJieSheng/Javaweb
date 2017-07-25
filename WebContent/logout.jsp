<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>退出</title>
</head>
<body>
     <%session.removeAttribute("userID");
       session.invalidate();
       request.removeAttribute("username");%>
     <div align="center">
         <%response.setHeader("refresh", "3;login.jsp"); %>
         <p>系统检测到您未登录，请登录后再操作！3秒后自动跳转至登录页面，若未跳转，请点击<a href="login.jsp">这里</a></p>
     </div>

</body>
</html>