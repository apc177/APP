package Data;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(name = "upload")
public class upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("来了熬");
        DiskFileItemFactory fu=new DiskFileItemFactory();
        fu.setSizeThreshold(2*1024*1024);
        fu.setSizeThreshold(4096);
        ServletFileUpload upload=new ServletFileUpload(fu);
        upload.setHeaderEncoding("utf-8");
        List<FileItem> fileItems =null;
        Map<String,String> res=new HashMap<>();
        try{
            fileItems=upload.parseRequest(request);
            Iterator<FileItem> iter=fileItems.iterator();
            while(iter.hasNext()){
                FileItem item = iter.next();
                if(!item.isFormField()){
                    String name1=item.getName();
                    long size = item.getSize();
                    if(name1==null||name1.equals("")&&size==0){
                        continue;
                    }
                    int end=name1.length();
                    int begin=name1.lastIndexOf("\\");
                    String newname=name1.substring(begin+1,end);
                    if(newname.length()==0){
                        System.out.println("上传了个jb");
                    }
                    else{
                        String rootdir=request.getRealPath("/");
                        String reladir=File.separator+"upload";
                        File fdir=new File(rootdir+reladir);
                        if(!fdir.exists()){
                            fdir.mkdirs();
                        }
                        String oriname=name1;
                        String new_name=System.currentTimeMillis()+"_"+oriname;
                        File tempfile=new File(fdir.getPath()+File.separator+new_name);

                        res.put("oriName",oriname);
                        res.put("realName",tempfile.getName());
                        System.out.println(reladir);
                        System.out.println(File.separator);
                        System.out.println(new_name);
                        res.put("realatPath","/"+reladir.substring(1)+"/"+new_name);
                        item.write(tempfile);
                        item.delete();
                        System.out.println("ojbk");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println( JSONObject.fromObject(res));
        response.getWriter().println(JSONObject.fromObject(res));
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);


    }
}
