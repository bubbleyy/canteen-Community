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
 * 用户公告详情
 */


@WebServlet("/UserGgdetailServlet")
public class UserGgdetailServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));



        UserListDao dao = new UserListDaoimpl();
        inform  gonggao = dao.findggdetail(id);
        dao.updategglooknumber(gonggao);
        request.setAttribute("gonggao",gonggao);
        request.getRequestDispatcher("user/ggdetail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
