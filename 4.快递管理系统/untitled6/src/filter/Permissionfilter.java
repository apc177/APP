package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebFilter(filterName="PermissionFilter",urlPatterns = {"*.jsp"},
//        initParams={
//                @WebInitParam(name = "ignores",
//                        value = "/login.jsp;/kaptcha/kaptcha.jpg;/css;/img;/js;po.jpg;/success.jsp;/registeredSucceed.jsp")})
public class Permissionfilter implements Filter {

    private String excludedPage;
    // 就是WebInitParam 中 value值的数组
    private String[] excludedPages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPage = filterConfig.getInitParameter("ignores");
        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(";");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /**
         * servletRequest 参数和servletResponse，都不带HTTP，
         * HttpServletRequest 是ServletRequest 子类。
         * 父类ServletRequest是无法访问session域对象的。需要向下类型转换。
         * HttpServletRequest req = (HttpServletRequest)servletRequest;
         *
         * 通过req 才可以访问session域对象
         */
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        HttpSession session = req.getSession();


        // 获取请求的url资源名称  /system/userList.jsp
        String servletPath = req.getServletPath();

        System.out.println("PermissionFilter 执行了");
        System.out.println("当前请求的资源为:"+servletPath);

        for(String item :excludedPages){
            if(servletPath.contains(item)){
                // 当前的请求url资源，是属于不验证的资源，直接放行。
                filterChain.doFilter(req,resp);
                return;// 后面的验证代码不再执行了。
            }
        }
        // 如果for循环遍历了一遍，当前的url请求资源，不在 ignores 放行资源清单中，那么就判断是否已经登陆。

        String loginUser = (String)session.getAttribute("name");
        String contextPath = req.getContextPath();

        if(loginUser==null||loginUser.isEmpty()){
            // session中没有用户信息，说明没有登陆
            // 输入的用户和密码不正确，请重新输入！
            System.out.println(loginUser);
            req.getSession().setAttribute("msg","没有登陆，无法访问系统资源!");
            // 转发或者重定向的登陆页面
            resp.sendRedirect(contextPath+"/login.jsp");
            return;
        }else{
            // 说明登陆成功了，可以继续访问系统资源; 放行了。
            filterChain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
