<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆失败</title>
</head>
<body>
    <%out.print("<script>alert('用户名或密码输入不正确，请重新输入！')</script>"); %>
    <%response.setHeader("refresh","0;./login.jsp");%>
    <p align="center">若网页无响应请点击<a href="login.jsp" >跳转</a>手动跳转至指定页面。</p>
</body>
</html>