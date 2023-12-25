package web.admin;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.stgly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 系统管理员端的食堂管理员主列表
 */

@WebServlet("/AStGlRyServlet")
public class AStGlRyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String stid = request.getParameter("stid");

        StListDao dao = new StListDaoimpI();
        List<stgly> stglies = dao.findstrygl(stid);


       request.setAttribute("stglies",stglies);

        request.setAttribute("stid",stid);
       request.getRequestDispatcher("admin/people/astgly.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }
}
