package web.user.huifu;

import dao.MenuListDao;
import dao.StListDao;
import dao.UserListDao;
import dao.impl.MenuListDaoimpI;
import dao.impl.StListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.*;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 菜品评论回复详情
 */

@WebServlet("/MenupinglunHuifuServlet")
public class MenupinglunHuifuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        MenuListDao dao = new MenuListDaoimpI();
        System.out.println("菜品评论id是"+id);
        menupinglun menupinglun = dao.findonlymenupinglun(id);

        menu menu = dao.findonlymenu(String.valueOf(menupinglun.getMenu_id()));

        StListDao dao1 = new StListDaoimpI();

        st st = dao1.findonlyst(String.valueOf(menu.getSt_id()));

        List<String> stfaceimg = JSONArray.fromObject(st.getPictures());

        UserListDao dao2 = new UserListDaoimpl();


        User user =  dao2.findisuser(menupinglun.getUser_username());

        List<menupinglunhuifu> menupinglunhuifus = dao.findmenupinglunhuifu(menupinglun.getId());


        request.setAttribute("menupinglun",menupinglun);
        request.setAttribute("st",st);
        request.setAttribute("stfaceimg",stfaceimg);
        request.setAttribute("user",user);
        request.setAttribute("menupinglunhuifus",menupinglunhuifus);
        request.getRequestDispatcher("user/mypublish/detail/menupinglunhuifu.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
