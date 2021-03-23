package html;

import mysql.Accountmysql;
import mysql.JsonData;
import mysql.UserInfo;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import sendmessage.httpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginjudge")
public class loginjudge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name").trim();
        response.setContentType("application/json;charset=utf-8");
        String password = new String(request.getParameter("password").trim().getBytes("UTF-8"),"utf-8");
        String id = request.getSession().getAttribute("googleVerifyCode").toString();
        id=id.substring(0,id.length()-1);
        System.out.println(name+password);
        String wt=request.getParameter("code");
        if(request.getHeader("mobile")!=null&&request.getHeader("mobile").equals("mobile")) {
            System.out.println("sdfgnm");
            int code;
            String msg,data="buzhidao";
            JSONObject jsonObject=new JSONObject();
            if (name.isEmpty() || password.isEmpty()) {
//                code=-1;
//                msg="账号密码不能为空";
                jsonObject.put("code",-1);
                jsonObject.put("msg", "账号密码不能为空");
            } else if (id.equals(wt)) {
//                code=-1;
//                msg="验证码不正确";
                jsonObject.put("code",-1);
               jsonObject.put("msg","验证码不正确");
            }else {
//                code=1;
//                msg="行";
                jsonObject.put("code",1);
                jsonObject.put("msg","行");

            }
            out.print(jsonObject);
//            System.out.println("JsonData [code=" + code + ", data=" + data + ", msg=" + msg + "]");
        }
        else if(name.isEmpty()||password.isEmpty())
        {
            out.print("账号密码不能为空");
            response.setHeader("refresh", "0;url=login.jsp");
        }else if(id.equals(wt)){
            out.print("验证码不正确");
            response.setHeader("refresh", "0;url=login.jsp");
        }
        else {
            try {
                if(new Accountmysql().login(name,password)){//登陆成功
                    request.getSession().setAttribute("name",name);

                    response.sendRedirect("/main_jsp/index.jsp");
                }else{
                    out.print("账号密码不正确");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
