package Data;

import mysql.expressmysql;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editlist")
public class editlist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int id=Integer.valueOf(request.getParameter("id"));
        String id = request.getParameter("id");
        String remarks = request.getParameter("remarks");
        if(request.getParameter("company")==null){
            boolean res= false;
            try {
                res = new expressmysql().updates_justremarks(Integer.valueOf(id),remarks);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject jsonObject=new JSONObject();
            if(res){
                jsonObject.put("message","成功辣");
                jsonObject.put("status","success");
            }
            else {
                jsonObject.put("message","失败辣");
                jsonObject.put("status","fail");
            }
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(jsonObject.toString());
        }
//        try {
//            boolean res=new Accountmysql().update(name,passwd);
//            JSONObject jsonObject=new JSONObject();
//            if(res){
//                jsonObject.put("message","成功辣");
//                jsonObject.put("status","success");
//            }
//            else {
//                jsonObject.put("message","失败辣");
//                jsonObject.put("status","fail");
//            }
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().print(jsonObject.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
