package Data;

import mysql.ReturnData;
import mysql.express;
import mysql.expressmysql;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

@WebServlet(name = "getmyexpress")
public class getmyexpress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String queryname=request.getParameter("queryName");
        String pagenumber=request.getParameter("pageIndex");
        String offset=request.getParameter("pageSize");
        String use=request.getParameter("use");
        try {

            backpage(username,queryname,pagenumber,offset,response,use);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
    private void backpage(String username,String name,String pagenumber,String offset,HttpServletResponse response,String use) throws Exception {
        ReturnData<express> returnData = new ReturnData<>();
        response.setContentType("application/json;charset=utf-8");
        List<express> list,query=new Vector<>();
        if(use==null)
          list=new expressmysql().querysome(username,name);
        else{
            list=new expressmysql().querysome2(username,name);
        }
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
