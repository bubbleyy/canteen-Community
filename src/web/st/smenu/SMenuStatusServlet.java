package web.st.smenu;

import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置食堂菜品状态（正常或异常）
 */

@WebServlet("/SMenuStatusServlet")
public class SMenuStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String menuid = request.getParameter("menuid");
        String status = request.getParameter("status");

        System.out.println("转化为"+status);
        MenuListDao dao = new MenuListDaoimpI();
       dao.updatestmenustatus(menuid,status);

        response.sendRedirect("SMenuServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }
}
