package web.st;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.login.loginstgly;
import domain.st;
import domain.stgly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 食堂端首页
 */

@WebServlet("/SstzhServlet")
public class SstzhServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         loginstgly loginstgly = (domain.login.loginstgly) request.getSession().getAttribute("loginuser");

        StListDao dao = new StListDaoimpI();

        stgly stgly = dao.findstglyusername(loginstgly.getUsername());

        st st = dao.findonlyst(String.valueOf(stgly.getSt_id()));

        request.setAttribute("stgly",stgly);
        request.setAttribute("st",st);

         request.getRequestDispatcher("st/stzh/stzh.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
