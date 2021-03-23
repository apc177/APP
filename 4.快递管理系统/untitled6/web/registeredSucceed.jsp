<%@ page import="java.net.URL" %>
<%@ page import="mysql.Accountmysql" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册成功页面</title>
</head>
<body>
<%!
    public static JSONObject get(String s){
        try {
            InputStream is = new URL(s).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            return JSONObject.fromObject(rd.readLine());
        }catch (Exception e){
        }
        return null;
    }%>
<%
    String name=request.getParameter("name").trim();//去除首尾空格
    String password=request.getParameter("password").trim();
    String refill=request.getParameter("double passwd").trim();
    String id = request.getSession().getAttribute("googleVerifyCode").toString();
    String tryCode =request.getParameter("code");
    if(name.isEmpty()||name.equals(" ")||password.isEmpty()){
        out.print("<script language='javaScript'> alert('账号密码不能为空—');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }else if(!tryCode.equals(id)){
        out.print("<script language='javaScript'> alert('验证码不正确');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    } else if(!password.equals(refill)){
        out.print("<script language='javaScript'> alert('两次密码不一致');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }else if(new Accountmysql().insert(name,password)){
        out.print("<script language='javaScript'> alert('注册成功');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }else{
        out.print("<script language='javaScript'> alert('账号已经存在');</script>");
        response.setHeader("refresh", "0;url=login.jsp");
    }
%>

</body>
</html>
