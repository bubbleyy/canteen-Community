package web.user;


import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import domain.inform;
import domain.login.loginuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * 登录操作
 */


@WebServlet("/UserGgServlet")
public class UserGgServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");

        System.out.println("登录账户"+loginuser);
        if (loginuser == null ){
            response.sendRedirect("login.jsp");
        }


        UserListDao dao = new UserListDaoimpl();
       List<inform>  gonggaos = dao.findgg();
        request.setAttribute("gonggaos",gonggaos);
        request.getRequestDispatcher("user/gg.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");

        UserListDao dao = new UserListDaoimpl();
        List<inform>  gonggaos = dao.findggsearch(name);
        request.setAttribute("gonggaos",gonggaos);
        request.getRequestDispatcher("user/gg.jsp").forward(request,response);

    }
}
