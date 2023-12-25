package web.admin.Acommunity;

import dao.CommunityListDao;
import dao.impl.CommunityListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 社区信息删除
 */

@WebServlet("/AcommunityxxdeleteServlet")
public class AcommunityxxdeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        CommunityListDao dao = new CommunityListDaoimpI();

        dao.deletecommunity(id);

        response.sendRedirect("AcommunityxxServlet");
    }
}
