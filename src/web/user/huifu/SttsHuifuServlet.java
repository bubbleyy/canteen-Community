package web.user.huifu;

import dao.StListDao;
import dao.UserListDao;
import dao.impl.StListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.User;
import domain.st;
import domain.stts;
import domain.sttshf;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 食堂投诉回复详情
 */

@WebServlet("/SttsHuifuServlet")
public class SttsHuifuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        StListDao dao = new StListDaoimpI();

        stts stts = dao.findstts(id);

        st st = dao.findonlyst(String.valueOf(stts.getSt_id()));
        List<String> stfaceimg = JSONArray.fromObject(st.getPictures());
        UserListDao dao1 = new UserListDaoimpl();


        User user =  dao1.findisuser(stts.getUser_username());

        List<sttshf> sttshuifus = dao.findsttshuifu(stts.getId());


        request.setAttribute("stts",stts);
        request.setAttribute("st",st);
        request.setAttribute("stfaceimg",stfaceimg);
        request.setAttribute("user",user);
        request.setAttribute("sttshuifus",sttshuifus);
        request.getRequestDispatcher("user/mypublish/detail/sttshuifu.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
