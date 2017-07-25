<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="beanDemo1.personInfo" %>
<%@page import="beanDemo1.moreInfo" %>
<%@page import="beanDemo1.educationalInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学籍教务系统</title>
<style type="text/css">
     *{margin: 0;padding: 0;}
     td>p{font-family: 华文楷体;font-size: x-large;font-weight: bolder;color: white;}
     td[class]{background-color: gray;}
     #eduInfo{display: none;}
</style>
<script type="text/javascript">
	var showPersonInfo=function() {
		document.getElementById("eduInfo").style.display="none";
		document.getElementById("PersonInfo").style.display="block";
	}
	var showMoreInfo=function() {
		document.getElementById("PersonInfo").style.display="none";
		document.getElementById("eduInfo").style.display="block";
	}
</script>
</head>
<body>
     <%String user=(String)session.getAttribute("userID");
      if(user==null){
    	  %>
    	  <jsp:forward page="logout.jsp"></jsp:forward>
    <%	  
      }
      %>
      <% String readonly="";
      personInfo person=(personInfo)session.getAttribute("personinfo");
      moreInfo minfo=(moreInfo)session.getAttribute("moreinfo");
      educationalInfo eduInfo=(educationalInfo)session.getAttribute("educationalinfo");
      session.setAttribute("studentusername", person.getUsername());
      if(minfo==null&&eduInfo==null){
    	  minfo=new moreInfo();
    	  eduInfo=new educationalInfo();
      }else if(minfo==null){
    	  minfo=new moreInfo();
      }else if(eduInfo==null){
    	  eduInfo=new educationalInfo();
      }
      if((int)session.getAttribute("power")==0){
    	  readonly="readonly=\"true\"";
      }else{
    	  readonly="";
      }
     %>
      
    <div style="background-color: black;width:100%;height: 20px;text-align: center;margin: 0;padding: 0;position: relative;" >
		<p style="color:white;float: left"><%=user %></p>
        <p style="color: white;float: right"><a href="logout.jsp" style="color: white;">退出</a></p>
	</div >
	<div style="position: absolute;bottom: 20px;top: 20px;width: 10%;background-color: gray;">
	     <button onclick="showPersonInfo()" style="background-color: blue;font-family: 华文楷体;font-size: large;font-weight: bold;text-align: center;width: 100%">个人详细信息</button>
	     <button onclick="showMoreInfo()" style="background-color: gold;font-family: 华文楷体;font-size: large;font-weight: bold;text-align: center;width: 100%">教务信息</button>
	</div>
	<div id="PersonInfo" style="position: absolute;bottom: 20px;top: 20px;left: 10%;width: 90%;background-color: white;background: url(res/bg4.jpg)">
	      <form action="<%=this.getServletContext().getContextPath()+"/moreInfoServlet"%>" method="get" target="_self">
	           <table align="center" border="2" bordercolor="gray" >
	              <tr>
	                 <td><p>姓名</p></td>
	                 <td class=""><input type="text" name="name" value="<%=person.getName()!=null?person.getName():""%>" <%=readonly%>></td>
	                 <td><p>年龄</p></td>
	                 <td class=""><input type="text" name="age" value="<%=person.getAge()!=null?person.getAge():""%>" <%=readonly%>></td>
	                 <td><p>学号</p></td>
	                 <td class=""><input type="text" name="number" value="<%=minfo.getNumber()!=null?minfo.getNumber():""%>" <%=readonly%>/></td>
	              </tr>
	              <tr>
	                 <td><p>籍贯</p></td>
	                 <td class=""><input type="text" name="local" value="<%=person.getLocal()!=null?person.getLocal():""%>" <%=readonly%>></td>
	                 <td><p>民族</p></td>
	                 <td class=""><input type="text" name="people" value="<%=person.getPeople()!=null?person.getPeople():""%>" <%=readonly%>></td>
	                 <td><p>健康状况</p></td>
	                 <td class=""><input type="text" name="health" value="<%=minfo.getHealth()!=null?minfo.getHealth():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>性别</p></td>
	                 <td class=""><input type="text" name="sexy" value="<%=person.getSexy()!=null?person.getSexy():""%>" <%=readonly%>></td>
	                 <td><p>政治面貌</p></td>
	                 <td class=""><input type="text" name="status" value="<%=person.getStatus()!=null?person.getStatus():""%>" <%=readonly%>></td>
	                 <td><p>婚姻状况</p></td>
	                 <td class=""><input type="text" name="marry" value="<%=minfo.getMarry()!=null?minfo.getMarry():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>住址</p></td>
	                 <td class=""><input type="text" name="home" value="<%=person.getHome()!=null?person.getHome():""%>" <%=readonly%>></td>
	                 <td><p>联系电话</p></td>
	                 <td class=""><input type="text" name="phonenumber" value="<%=person.getPhonenumber()!=null?person.getPhonenumber():""%>" <%=readonly%>></td>
	                 <td><p>出生日期</p></td>
	                 <td class=""><input type="text" name="birth" value="<%=minfo.getBirth()!=null?minfo.getBirth():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>年级</p></td>
	                 <td class=""><input type="text" name="education" value="<%=minfo.getEducation()!=null?minfo.getEducation():""%>" <%=readonly%>></td>
	                 <td><p>学院</p></td>
	                 <td class=""><input type="text" name="college" value="<%=minfo.getCollege()!=null?minfo.getCollege():""%>" <%=readonly%>></td>
	                 <td><p>专业</p></td>
	                 <td class=""><input type="text" name="major" value="<%=minfo.getMajor()!=null?minfo.getMajor():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>身高</p></td>
	                 <td class=""><input type="text" name="length" value="<%=minfo.getLength()!=null?minfo.getLength():""%>" <%=readonly%>></td>
	                 <td><p>体重</p></td>
	                 <td class=""><input type="text" name="weight" value="<%=minfo.getWeight()!=null?minfo.getWeight():""%>" <%=readonly%>></td>
	                 <td><p>爱好</p></td>
	                 <td class=""><input type="text" name="hobby" value="<%=minfo.getHobby()!=null?minfo.getHobby():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <th colspan="6" align="center">
	                    <input type="submit" value="保存修改" style="font-family: 华文楷体;font-size: medium;font-weight: bold;">
	                 </th>
	              </tr>
	           </table>
	      </form>
	</div>
	<div id="eduInfo" style="position: absolute;bottom: 20px;top: 20px;left: 10%;width: 90%;background-color: yellow;background: url(res/bg5.jpg)">
	      <form action="<%=this.getServletContext().getContextPath()+"/educationalServlet" %>" method="get" target="_self">
	           <table align="center" border="2" bordercolor="gray" >
	              <tr>
	                 <td><p>姓名</p></td>
	                 <td class=""><input type="text" name="name" value="<%=person.getName()!=null?person.getName():""%>" <%=readonly%>></td>
	                 <td><p>专业</p></td>
	                 <td class=""><input type="text" name="major" value="<%=minfo.getMajor()!=null?minfo.getMajor():""%>" <%=readonly%>></td>
	                 <td><p>学号</p></td>
	                 <td class=""><input type="text" name="number" value="<%=minfo.getNumber()!=null?minfo.getNumber():""%>" <%=readonly%>/></td>
	              </tr>
	              <tr>
	                 <td><p>高数上</p></td>
	                 <td class=""><input type="text" name="math1" value="<%=eduInfo.getMath1()!=null?eduInfo.getMath1():""%>" <%=readonly%>></td>
	                 <td><p>高数下</p></td>
	                 <td class=""><input type="text" name="math2" value="<%=eduInfo.getMath2()!=null?eduInfo.getMath2():""%>" <%=readonly%>></td>
	                 <td><p>大物上</p></td>
	                 <td class=""><input type="text" name="physical1" value="<%=eduInfo.getPhysical1()!=null?eduInfo.getPhysical1():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>大物下</p></td>
	                 <td class=""><input type="text" name="physical2" value="<%=eduInfo.getPhysical2()!=null?eduInfo.getPhysical2():""%>" <%=readonly%>></td>
	                 <td><p>英语一</p></td>
	                 <td class=""><input type="text" name="english1" value="<%=eduInfo.getEnglish1()!=null?eduInfo.getEnglish1():""%>" <%=readonly%>></td>
	                 <td><p>英语二</p></td>
	                 <td class=""><input type="text" name="english2" value="<%=eduInfo.getEnglish2()!=null?eduInfo.getEnglish2():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>英语三</p></td>
	                 <td class=""><input type="text" name="english3" value="<%=eduInfo.getEnglish3()!=null?eduInfo.getEnglish3():""%>" <%=readonly%>></td>
	                 <td><p>英语四</p></td>
	                 <td class=""><input type="text" name="english4" value="<%=eduInfo.getEnglish4()!=null?eduInfo.getEnglish4():""%>" <%=readonly%>></td>
	                 <td><p>算法</p></td>
	                 <td class=""><input type="text" name="algorithm" value="<%=eduInfo.getAlgorithm()!=null?eduInfo.getAlgorithm():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>数据结构</p></td>
	                 <td class=""><input type="text" name="datastruct" value="<%=eduInfo.getDatastruct()!=null?eduInfo.getDatastruct():""%>" <%=readonly%>></td>
	                 <td><p>数据库</p></td>
	                 <td class=""><input type="text" name="database" value="<%=eduInfo.getDatabase()!=null?eduInfo.getDatabase():""%>" <%=readonly%>></td>
	                 <td><p>操作系统</p></td>
	                 <td class=""><input type="text" name="os" value="<%=eduInfo.getOs()!=null?eduInfo.getOs():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <td><p>iOS</p></td>
	                 <td class=""><input type="text" name="iOS" value="<%=eduInfo.getiOS()!=null?eduInfo.getiOS():""%>" <%=readonly%>></td>
	                 <td><p>Android</p></td>
	                 <td class=""><input type="text" name="android" value="<%=eduInfo.getAndroid()!=null?eduInfo.getAndroid():""%>" <%=readonly%>></td>
	                 <td><p>计算机网络</p></td>
	                 <td class=""><input type="text" name="internet" value="<%=eduInfo.getInternet()!=null?eduInfo.getInternet():""%>" <%=readonly%>></td>
	              </tr>
	              <tr>
	                 <th colspan="6" align="center">
	                    <input type="submit" value="保存修改" style="font-family: 华文楷体;font-size: medium;font-weight: bold;">
	                 </th>
	              </tr>
	           </table>
	      </form>
	</div>
    <div style="background-color: black;text-align: center;margin: 0;padding: 0;width: 100%;height: 20px;bottom: 0px;position: absolute; ">
        <p style="color:white;"><%="网站访问人次数："+application.getAttribute("visitCount") %></p>
    </div>
</body>
</html>