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
 * 设置食堂管理员状态（正常或异常）
 */

@WebServlet("/AStGlRyStatusServlet")
public class AStGlRyStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String stid = request.getParameter("stid");
        String username = request.getParameter("username");
        String status = request.getParameter("status");

        System.out.println("转化为"+status);
        StListDao dao = new StListDaoimpI();
       dao.updatestglystatus(username,status);

        response.sendRedirect("AStGlRyServlet?stid="+stid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }
}
