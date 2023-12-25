package web.user.mypublish;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.login.loginuser;
import domain.menupinglun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 我的菜品评论
 */

@WebServlet("/MymenupinglunServlet")
public class MymenupinglunServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");
        StListDao dao = new StListDaoimpI();
//        查找菜品评论

        List<menupinglun> mypingluns = dao.findmymenupinglun(loginuser.getUsername());




        request.setAttribute("mypingluns",mypingluns);

        request.getRequestDispatcher("user/mypublish/mymenupinglun.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
