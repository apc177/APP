package Data;
import mysql.Accountmysql;
import mysql.ReturnData;
import mysql.SysUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "gettempdata")
public class gettempdata extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String queryname=request.getParameter("queryName");
    String pagenumber=request.getParameter("pageIndex");
    String offset=request.getParameter("pageSize");
        try {
            backpage(queryname,pagenumber,offset,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
    private void backpage(String name,String pagenumber,String offset,HttpServletResponse response) throws Exception {
        ReturnData<SysUser> returnData = new ReturnData<>();
        response.setContentType("application/json;charset=utf-8");
        List<SysUser> list=new Accountmysql().querypart(name),query=new Vector<>();
        returnData.setTotal(list.size());
        int intoff=Integer.valueOf(offset);
        int pgn=Integer.valueOf(pagenumber);
        int end=(intoff*(pgn))>list.size()?(list.size()):(intoff*(pgn));
        System.out.println(pgn*intoff+" "+end);
        for(int i=pgn*intoff-intoff;i<end;i++){
            query.add(list.get(i));
        }
        returnData.setRows(query);
        response.getWriter().print(JSONObject.fromObject(returnData));
    }
}
