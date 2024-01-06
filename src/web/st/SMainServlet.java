package web.st;

import dao.MenuListDao;
import dao.StListDao;
import dao.UserListDao;
import dao.impl.MenuListDaoimpI;
import dao.impl.StListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.*;
import domain.login.loginuser;
import domain.pinglun.userpinglun;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 食堂
 */

@WebServlet("/SMainServlet")
public class SMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stid = request.getParameter("stid");
        StListDao dao = new StListDaoimpI();


        st st = dao.findonlyst(stid);
        List<String> stpictures = JSONArray.fromObject(st.getPictures());


//        查找菜品

        MenuListDao dao1 = new MenuListDaoimpI();

        List<menu> menus = dao1.findstcp(stid);

        List<List<String>> stcppictures = new ArrayList<>();

        for (int i =0;i<menus.size() ;i++ ){
            if (menus.get(i).getPictures().length() != 0){
                List<String> itempicture =   JSONArray.fromObject(menus.get(i).getPictures());
                stcppictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                stcppictures.add(itempicture);
            }

        }

//        查找食堂公告


            UserListDao dao2 = new UserListDaoimpl();

            List<inform> gonggaos = dao2.findstgg(stid);


//        查找食堂评论

        List<userpinglun> userpingluns = new ArrayList<>();

        List<stpinglun> stpingluns = dao.findstpinglun(stid);

        for (int i=0;i<stpingluns.size();i++){
            User user = dao2.findisuser(stpingluns.get(i).getUser_username());
            userpinglun userpinglun = new userpinglun();
            userpinglun.setUser(user);
            userpinglun.setStpinglun(stpingluns.get(i));
            userpingluns.add(userpinglun);
        }


//        查找用户是否已评论过一次
        boolean stuserpinglun  = false;
        if (request.getSession().getAttribute("logintype").equals("师生用户")){

            loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");
            stpinglun stpinglun =  dao.finduserpinglun(loginuser.getUsername(),st.getId());

            if (stpinglun != null){
                stuserpinglun = true;
            }

        }

//        更新食堂浏览量
        dao.updatestlooknumber(st.getLooknumber()+1,st.getId());

        request.setAttribute("st",st);
        request.setAttribute("stpictures",stpictures);
        request.setAttribute("menus",menus);
        request.setAttribute("stcppictures",stcppictures);
        request.setAttribute("gonggaos",gonggaos);
//        判断是否评论过
        request.setAttribute("userpingluns",userpingluns);
        request.setAttribute("stuserpinglun",stuserpinglun);
        request.getRequestDispatcher("st/smain.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
