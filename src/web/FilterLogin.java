
package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebFilter("/*")
public class FilterLogin implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        System.out.println(url);
        Object loginuser =request.getSession().getAttribute("loginuser");

        if (url.equals("/") || url.equals("/menujavaweb_war_exploded/")) {
            response.sendRedirect("IndexServlet");
            return;
        }

        if (url.contains("/login.jsp") || url.contains("/upload")){
            filterChain.doFilter(request,response);
            return;
        }

        if (url.contains("/js") || url.contains("/imgs") || url.contains("/css") || url.contains("/layui")){
            filterChain.doFilter(request,response);
            System.out.println("我的静态资源放行了");
            return;
        }

        if (  url.contains("/IndexServlet") ||  url.contains("/loginServlet") || url.contains("/register.jsp") || url.contains("/registerServerlet")  || url.contains("/index.jsp")  ){
            filterChain.doFilter(request,response);
            return;
        }



        if (loginuser != null){
            filterChain.doFilter(request,response);
            return;
        }



        System.out.println("被拦截了");
        response.sendRedirect("login.jsp");


    }

    @Override
    public void destroy() {

    }
}


