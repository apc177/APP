<%@ page import="java.net.URL" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.InputStreamReader" %><%--
  Created by IntelliJ IDEA.
  User: Ryota
  Date: 2020/6/5
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <img alt="image" class="rounded-circle" src="https://api.vvhan.com/api/girl" height="48" width="48"/>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="block m-t-xs font-bold"><%out.print(request.getSession().getAttribute("name"));%></span>
                        <span class="text-muted text-xs block"><%
                            out.print(new BufferedReader(new InputStreamReader((new URL("https://api.vvhan.com/api/sao").openConnection().getInputStream()),"utf-8")).readLine());
                        %> <b class="caret"></b></span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="dropdown-item" href="profile.html">个人信息</a></li>
                        <li><a class="dropdown-item" href="contacts.html">我的订单</a></li>
                        <li class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="login.html">登出</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    IN+
                </div>
            </li>
            <li >
                <a href="index.jsp" aria-expanded="false"><i class="fa fa-th-large"></i> <span class="nav-label">未派送快递qwq</span> <span class="fa arrow"></span></a>
            </li>
            <li>
                <a href="addlist.jsp" aria-expanded="false"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">给我整俩快递</span><span class="fa arrow"></span></a>

            </li>
            <li>
                <a href="all.jsp"aria-expanded="false"><i class="fa fa-envelope"></i> <span class="nav-label">整过的快递 </span><span class="label label-warning float-right">已完成/未完成</span></a>

            </li>
<%--            <li>--%>
<%--                <a ><i class="fa fa-laptop"></i> <span class="nav-label">已购订单完成情况</span>  </a>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <a ><i class="fa fa-laptop"></i> <span class="nav-label">了解更多</span></a>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">联系客服</span><span class="fa arrow"></span></a>--%>
<%--                <ul class="nav nav-second-level collapse">--%>
<%--                    <li><a href="form_basic.html">客服①</a></li>--%>
<%--                    <li><a href="form_advanced.html">客服①</a></li>--%>
<%--                    <li><a href="form_wizard.html">客服①</a></li>--%>
<%--                    <li><a href="form_file_upload.html">客服①</a></li>--%>
<%--                    <li><a href="form_editors.html">客服①</a></li>--%>
<%--                    <li><a href="form_autocomplete.html">客服①</a></li>--%>
<%--                    <li><a href="form_markdown.html">客服①</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>
<%--            <li class="landing_link">--%>
<%--                <a target="_blank" href="landing.html"><i class="fa fa-star"></i> <span class="nav-label">加入会员</span> <span class="label label-warning float-right">新</span></a>--%>
<%--            </li>--%>
            <li class="special_link">
                <a href="package.html"><i class="fa fa-database"></i> <span class="nav-label">打印电子发票</span></a>
            </li>
        </ul>

    </div>
</nav>
<script>
    function goToUrl(url,method,params){
        var form = document.createElement("form");
        form.action = url;
        form.method = method;
        form.style.display = "none";
        document.body.appendChild(form);
        params.forEach(function (param) {
            sessionStorage.setItem(params.name,param.data);
        });
        form.submit();
        return form;
    }
</script>
</body>
</html>
