package web.user.menu;


import dao.MenuListDao;
import dao.StListDao;
import dao.UserListDao;
import dao.impl.MenuListDaoimpI;
import dao.impl.StListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.login.loginuser;
import domain.menu;
import domain.menupinglun;
import domain.pinglun.usermenupinglun;
import domain.st;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 菜品详情
 */


@WebServlet("/MenuDetailServlet")
public class MenuDetailServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        //        查找菜品
        MenuListDao dao = new MenuListDaoimpI();


        menu menu = dao.findonlymenu(id);

        StListDao dao1 = new StListDaoimpI();

        st st = dao1.findonlyst(String.valueOf(menu.getSt_id()));


        List<String> menupictures = JSONArray.fromObject(menu.getPictures());



//        查找菜品评论

        List<usermenupinglun> usermenupingluns = new ArrayList<>();

        List<menupinglun> menupingluns = dao.findmenupinglun(id);

        UserListDao dao2 = new UserListDaoimpl();
        for (var i=0;i<menupingluns.size();i++){
            domain.User user = dao2.findisuser(menupingluns.get(i).getUser_username());
            usermenupinglun usermenupinglun = new usermenupinglun();
            usermenupinglun.setUser (user);
            usermenupinglun.setMenupinglun(menupingluns.get(i));
            usermenupingluns.add(usermenupinglun);
        }


//        查找用户是否已评论过一次
        var menuuserpinglun  = false;
        if (request.getSession().getAttribute("logintype").equals("师生用户")){

            loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");
            menupinglun menupinglun =  dao.findusermenupinglun(loginuser.getUsername(),menu.getId());

            if (menupinglun != null){
                menuuserpinglun = true;
            }

        }

//        更新菜品浏览量
        dao.updatestmenulooknumber(menu.getLooknumber()+1,menu.getId());

        request.setAttribute("menu",menu);
        request.setAttribute("st",st);
        request.setAttribute("menupictures",menupictures);
//        判断是否评论过
        request.setAttribute("usermenupingluns",usermenupingluns);
        request.setAttribute("menuuserpinglun",menuuserpinglun);
        request.getRequestDispatcher("st/smenudetail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
