package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"*"})
class edcoding implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Encoding is working");
//        req.getMethod();
//        ServletRequest 需要向下类型转换
        HttpServletRequest request = (HttpServletRequest)req;
        // 判断请求的方式为post时，需要指定utf-8编码方式
        if(request.getMethod().equalsIgnoreCase("post")){
            // 对request添加字符编码utf-8
            request.setCharacterEncoding("utf-8");
        }
        System.out.println("请求的queryString:"+request.getQueryString());
        System.out.println("请求的ServletPath:"+request.getServletPath());
        System.out.println("请求的RequestURI:"+request.getRequestURI());

        // 对response设置编码方式
        // text/html;charset=utf-8 返回html页面
        // application/json;charset=utf-8 返回json数据
        resp.setContentType("application/json;charset=utf-8");

        // 放行用户的请求
        chain.doFilter(request, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}