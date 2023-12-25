package web.user.huifu;

import dao.StListDao;
import dao.UserListDao;
import dao.impl.StListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.User;
import domain.st;
import domain.stpinglun;
import domain.stpinglunhuifu;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 食堂评论回复详情
 */

@WebServlet("/StpinglunHuifuServlet")
public class StpinglunHuifuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        StListDao dao = new StListDaoimpI();

        stpinglun stpinglun = dao.findonlystpinglun(id);

        st st = dao.findonlyst(String.valueOf(stpinglun.getSt_id()));

        List<String> stfaceimg = JSONArray.fromObject(st.getPictures());

        UserListDao dao1 = new UserListDaoimpl();


        User user =  dao1.findisuser(stpinglun.getUser_username());

        List<stpinglunhuifu> stpinglunhuifus = dao.findstpinglunhuifu(stpinglun.getId());


        request.setAttribute("stpinglun",stpinglun);
        request.setAttribute("st",st);
        request.setAttribute("stfaceimg",stfaceimg);
        request.setAttribute("user",user);
        request.setAttribute("stpinglunhuifus",stpinglunhuifus);
        request.getRequestDispatcher("user/mypublish/detail/stpinglunhuifu.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
