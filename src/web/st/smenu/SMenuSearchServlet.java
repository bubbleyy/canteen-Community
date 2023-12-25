package web.st.smenu;


import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
import domain.menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 菜品搜索
 */


@WebServlet("/SMenuSearchServlet")
public class SMenuSearchServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String menuname = request.getParameter("menuname");
        String stid = request.getParameter("stid");

        //        查找菜品
        MenuListDao dao = new MenuListDaoimpI();


        List<menu> menus = dao.findstpclike(Integer.parseInt(stid),menuname);


        request.setAttribute("menus",menus);
        request.getRequestDispatcher("user/menulist.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
