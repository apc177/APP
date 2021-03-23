<%@ page import="java.net.URL" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Sign Up Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>

<body>
<script  src="js/index.js"></script>
<%!
    public  JSONObject get(String s){
        try {
            InputStream is = new URL(s).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            return JSONObject.fromObject(rd.readLine());
        }catch (Exception e){
        }
        return null;
    }%>
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

<%--<c:if test="${ sessionScope.msg != null}">--%>
<%--    <script>--%>
<%--        toastr.warning(sessionScope.msg);--%>
<%--    </script>>--%>
<%--</c:if>--%>
<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <h2>LOGIN</h2>
                        <p>登陆登陆gkd</p>
                        <button class="btn_login" onClick="cambiar_login()">登录</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>SIGN UP</h2>
                        <p>注册注册冲冲冲</p>
                        <button class="btn_sign_up" onClick="cambiar_sign_up()">注册</button>
                    </div>
                </div>
            </div>
            <div class="cont_back_info">
                <div class="cont_img_back_grey"> <img src="po.jpg" alt="" /> </div>
            </div>

            <div class="cont_forms" >
                <form action="loginjudge" method="post">
                    <div class="cont_img_back_"> <img src="po.jpg" alt="" /> </div>
                    <div class="cont_form_login">
                        <h2>登录</h2>
                        <input type="text" name="name" placeholder="账号" />
                        <input type="password" name="password" placeholder="密码" />
                        <input  type="text"    name="code" placeholder="验证码" style="width:80px;height:10px;"  />
                        <img id="limgTryCode" width="160px" height="50px" src="${pageContext.request.contextPath}/kaptcha/kaptcha.jpg">
                        <a href="#" onclick="lchangeTryCode()"><span style="margin-left: 20px">看不清，换一张</span></a>
                        <script type="text/javascript">
                            function lchangeTryCode() {
                                var img = document.getElementById("limgTryCode");
                                img.src="${pageContext.request.contextPath}/kaptcha/kaptcha.jpg?d="+new Date()*1
                            }
                        </script>
                        <button class="btn_login"  onClick="cambiar_login()">登录</button>
                    </div>

                </form>
                <form action="registeredSucceed.jsp" method="post">
                    <div class="cont_form_sign_up">
                        <h2>注册</h2>
                        <input type="text" name="name" placeholder="账号" />
                        <input type="password" name="password" placeholder="密码" />
                        <input type="password"  name="double passwd" placeholder="确定密码" />
                        <input type="text" name="code" placeholder="验证码" style="width:80px;height:10px;"  />
                        <img id="imgTryCode" width="160px" height="50px" src="${pageContext.request.contextPath}/kaptcha/kaptcha.jpg">
                        <a href="#" onclick="changeTryCode()"><span style="margin-left: 20px">看不清，换一张</span></a>
                        <script type="text/javascript">
                            function changeTryCode() {
                                var img = document.getElementById("imgTryCode");
                                img.src="${pageContext.request.contextPath}/kaptcha/kaptcha.jpg?d="+new Date()*1
                            }
                        </script>
                        <button class="btn_sign_up" onClick="cambiar_sign_up()">立刻gkd！</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

        <c:if test="${ sessionScope.msg != null}">
            <script>
                toastr.warning(sessionScope.msg);
            </script>>
        </c:if>

<script src="main_jsp/js/plugins/toastr/toastr.min.js"></script>
</body>
</html>
