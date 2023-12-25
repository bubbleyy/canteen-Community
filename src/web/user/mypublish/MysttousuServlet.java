package web.user.mypublish;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.login.loginuser;
import domain.stts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 我的食堂投诉
 */

@WebServlet("/MysttousuServlet")
public class MysttousuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");
        StListDao dao = new StListDaoimpI();

        List<stts> mytousus = dao.findmysttousu(loginuser.getUsername());




        request.setAttribute("mytousus",mytousus);

        request.getRequestDispatcher("user/mypublish/mystts.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
