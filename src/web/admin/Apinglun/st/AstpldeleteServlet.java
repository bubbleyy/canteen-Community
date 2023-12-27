package web.admin.Apinglun.st;

import dao.StListDao;
import dao.impl.StListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 食堂评论信息删除
 */

@WebServlet("/AstpldeleteServlet")
public class AstpldeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        StListDao dao = new StListDaoimpI();

        dao.deletestpinglun(id);

        response.sendRedirect("AstplServlet");
    }
}
