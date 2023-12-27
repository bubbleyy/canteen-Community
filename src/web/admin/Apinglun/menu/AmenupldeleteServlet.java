package web.admin.Apinglun.menu;

import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 菜品评论信息删除
 */

@WebServlet("/AmenupldeleteServlet")
public class AmenupldeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        MenuListDao dao = new MenuListDaoimpI();

        dao.deletemenupinglun(id);

        response.sendRedirect("AmenuplServlet");
    }
}
