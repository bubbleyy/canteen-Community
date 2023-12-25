package web.user.huifu;

import dao.StListDao;
import dao.impl.StListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 食堂投诉回复状态已读未读
 */

@WebServlet("/SttsHuifuStatusServlet")
public class SttsHuifuStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String stts_id = request.getParameter("stts_id");

        StListDao dao = new StListDaoimpI();

        dao.updatesttshuifuyidu(id);



        request.getRequestDispatcher("SttsHuifuServlet?id="+stts_id).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
