package Data;

import mysql.expressmysql;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "qianshou")
public class qianshou extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        Boolean res = false;
        try {
            res = new expressmysql().qianshou(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(id);
        JSONObject jsonObject = new JSONObject();
        if (res) {
            jsonObject.put("message", "签收成功辣");
            jsonObject.put("status", "success");
        } else {
            jsonObject.put("message", "签收失败辣");
            jsonObject.put("status", "fail");
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonObject.toString());
    }
}
