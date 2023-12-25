package web.user.huifu;

import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 菜品评论回复已读未读状态
 */

@WebServlet("/MenupinglunHuifuStatusServlet")
public class MenupinglunHuifuStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String menupl_id = request.getParameter("menupl_id");

        MenuListDao dao = new MenuListDaoimpI();

        dao.updatemenupinglunhuifuyidu(id);



        request.getRequestDispatcher("MenupinglunHuifuServlet?id="+menupl_id).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
