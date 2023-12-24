package web.user;


import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import domain.admin;
import domain.login.loginadmin;
import domain.login.loginstgly;
import domain.login.loginuser;
import domain.stgly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 我的账户
 */


@WebServlet("/UserMyzhServlet")
public class UserMyzhServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");

        System.out.println("登录账户"+loginuser);
        if (loginuser == null || !loginuser.getLogintype().equals("师生用户")){
            response.sendRedirect("login.jsp");
        }
        UserListDao dao = new UserListDaoimpl();
        String password = dao.findmyzhpawwsord(loginuser.getUsername());
        User user = (User) dao.findisuser(loginuser.getUsername());
        System.out.println("账户密码"+password);
        request.setAttribute("password",password);
        request.setAttribute("user",user);
        request.getRequestDispatcher("user/myzh.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
