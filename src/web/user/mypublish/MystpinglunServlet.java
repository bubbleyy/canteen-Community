package web.user.mypublish;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.login.loginuser;
import domain.stpinglun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 我的食堂评论
 */

@WebServlet("/MystpinglunServlet")
public class MystpinglunServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");
        StListDao dao = new StListDaoimpI();
//        查找食堂评论

        List<stpinglun> mypingluns = dao.findmystpinglun(loginuser.getUsername());




        request.setAttribute("mypingluns",mypingluns);

        request.getRequestDispatcher("user/mypublish/mystpinglun.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
