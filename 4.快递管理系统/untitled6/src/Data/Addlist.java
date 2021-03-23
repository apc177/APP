package Data;

import mysql.Accountmysql;
import mysql.SysUser;
import mysql.expressmysql;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Addlist")
public class Addlist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //data:{"name":uname,"remarks":ramark,"image":imageurl,"tel":telephone,"company":company,"sender":sender,"address":address},
        String name = request.getParameter("name");
        String remark = request.getParameter("remarks");
        String image=request.getParameter("image");
        String tel=request.getParameter("tel");
        String company=request.getParameter("company");
        String sender=request.getParameter("sender");
        String address=request.getParameter("address");
        String addressee=request.getParameter("addressee");
        System.out.println(name+remark+image+tel+company+sender+address);

        try {
            boolean res=new expressmysql().insert(name,remark,image,tel,company,sender,address,addressee);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
