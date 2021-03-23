package Data;

import mysql.Accountmysql;
import net.sf.json.JSONObject;

import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@WebServlet(name = "judgelogin")
public class judgelogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String password = request.getParameter("password").trim();
        String id= (request.getParameter("transferData"));
        String wt=request.getParameter("code");
        JSONObject res=(get("http://hb9.api.yesapi.cn/?s=App.Captcha.Verify&app_key=C6F9CDC8318546E4D0BED3C27E21499A&sign=7463B3B4CE0C5014BAD579DD1B80D544&captcha_code="+wt+"&captcha_id="+id)).getJSONObject("data");
        JSONObject ans=new JSONObject();
        if(res.getInt("err_code")==0){
            try {
                if(new Accountmysql().login(name,password)==true){
                    ans.put("message","成功!");
                    ans.put("code",1);
                }
                else {
                    ans.put("message","密码不存在or账号不存在!");
                    ans.put("code",0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
        ans.put("message","验证码错误!");
        ans.put("code",0);
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(ans);
    }
    public static JSONObject get(String s){
        try {
            InputStream is = new URL(s).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            return JSONObject.fromObject(rd.readLine());
        }catch (Exception e){
        }
        return null;
    }
}
