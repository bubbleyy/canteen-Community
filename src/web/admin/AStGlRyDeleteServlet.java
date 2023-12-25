package web.admin;

import dao.StListDao;
import dao.impl.StListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除食堂管理员
 */

@WebServlet("/AStGlRyDeleteServlet")
public class AStGlRyDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String stid= request.getParameter("stid");

        StListDao dao = new StListDaoimpI();
       dao.deletestgly(username);

       response.sendRedirect("AStGlRyServlet?stid="+stid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
