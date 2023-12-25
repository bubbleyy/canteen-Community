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
 * 食堂评论回复已读未读状态设置
 */

@WebServlet("/StpinglunHuifuStatusServlet")
public class StpinglunHuifuStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String stpl_id = request.getParameter("stpl_id");

        StListDao dao = new StListDaoimpI();

        dao.updatestpinglunhuifuyidu(id);



        request.getRequestDispatcher("StpinglunHuifuServlet?id="+stpl_id).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
