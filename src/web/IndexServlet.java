package web;

import dao.CommunityListDao;
import dao.StListDao;
import dao.impl.CommunityListDaoimpI;
import dao.impl.StListDaoimpI;
import domain.community;
import domain.st;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * 首页
 */

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StListDao dao = new StListDaoimpI();

        List<st> sts = dao.findallst();

        CommunityListDao dao1 = new CommunityListDaoimpI();

        List<community> communities = dao1.findallcommunities();

        request.setAttribute("sts",sts);
        request.setAttribute("communities",communities);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
