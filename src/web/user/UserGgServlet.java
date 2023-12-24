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

/**
 * 用户公告列表
 */


@WebServlet("/UserGgServlet")
public class UserGgServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");


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
