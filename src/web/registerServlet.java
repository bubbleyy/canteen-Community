package web;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/*
 * 用户注册
 */

@WebServlet("/registerServlet")
public class registerServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String username= request.getParameter("username");
        String wisdom = request.getParameter("wisdom");
        Map<String,String[]> map = request.getParameterMap();
        System.out.println("注册的用户名为"+username);
        System.out.println("身份为"+wisdom);
        domain.User registeruser = new domain.User();
        registeruser.setUsername(username);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
