<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
<script type="text/javascript">
</script>

    <style>
        body{background:url(res/bg2.jpg);background-repeat: no-repeat;background-size: cover;}
        p{font-family: 华文楷体;color: aqua;font-weight: bold;}
        .submit{font-family: 华文楷体;width: 50px}
    </style>
</head>
<body>
    <div align="center" style="padding-top: 200px">
        <form action="./loginServlet" method="get" target="_self" >
            <table id="register">
                <tr>
                    <td>
                        <p>用户名：</p>
                    </td>
                    <td>
                        <input type="text" id="username" name="username">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>密码：</p>
                    </td>
                    <td>
                        <input type="password" id="password1" name="psw">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="登录" class="submit">
                    </td>
                </tr>
            </table>
        </form>
        <a href="register.jsp">注册</a>
    </div>
</body>
</html>