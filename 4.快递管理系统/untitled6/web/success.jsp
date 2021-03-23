
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@ page import="java.net.URL" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="sendmessage.httpClient"%>
<%@ page import="mysql.Accountmysql" %>
<%request.setCharacterEncoding("utf-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>判断登录</title>
</head>
<body>
<%
    String name = request.getParameter("name").trim();
    String password = request.getParameter("password").trim();
    String id = request.getSession().getAttribute("googleVerifyCode").toString();
    id=id.substring(0,id.length()-1);
    System.out.println(name+password);
    String wt=request.getParameter("code");
    if(name.isEmpty()||password.isEmpty())
    {
        out.print("<script language='javaScript'> alert('账号密码不能为空');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }else if(id.equals(wt)){
        out.print("<script language='javaScript'> alert('验证码不正确"+wt+"');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }
    else if(new Accountmysql().login(name,password)){//登陆成功
        request.getSession().setAttribute("name",name);
        httpClient httpClient = new httpClient(response);
        httpClient.setParameter("name",name);
        httpClient.sendByPost("/main_jsp/index.jsp");
    }else{
        out.print("<script language='javaScript'> alert('账号密码不正确');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }
%>

</body>
<script type="text/javascript">

    function next(){
        window.location = "main_jsp/index.html";
    }

</script>
</html>
