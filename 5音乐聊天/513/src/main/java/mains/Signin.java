package mains;

import mysql.Accountmysql;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import java.io.IOException;


//登录验证
public class Signin extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        JSONObject ans=new JSONObject();
        try {
            String email=request.getParameter("email");
            boolean a=new Accountmysql().loginone(email,request.getParameter("passwd"));
            if (a) {//账号密码正确
                ans.put("ret",1);
                request.getSession().setAttribute("email",email);
                request.getSession().setMaxInactiveInterval(30 * 60);
            }else {//账号密码错误
                ans.put("ret",2);
            }
            response.getOutputStream().print(ans.toString());//获得$.ajax的信息
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
