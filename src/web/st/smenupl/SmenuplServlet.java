package web.st.smenupl;


import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
import domain.login.loginstgly;
import domain.menu;
import domain.menupinglun;
import domain.menupinglunhuifu;
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
 * 菜品评论著列表
 */


@WebServlet("/SmenuplServlet")
public class SmenuplServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        loginstgly loginstgly = (domain.login.loginstgly) request.getSession().getAttribute("loginuser");


        MenuListDao dao = new MenuListDaoimpI();

        List<menu> menus = dao.findstallcp(loginstgly.getSt_id());
        List<menupinglun>  menupingluns = new ArrayList<>();
        for (var i =0;i<menus.size();i++){
            List<menupinglun>  menupinglunitem = dao.findmenupinglun(String.valueOf(menus.get(i).getId()));
            menupingluns.addAll(menupinglunitem);
        }

               List<List<String>> menuplpictures = new ArrayList<>();
               List<String> statuslist = new ArrayList<>();

        for (var i =0;i<menupingluns.size() ;i++ ){
            if (menupingluns.get(i).getPictures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(menupingluns.get(i).getPictures());
                menuplpictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                menuplpictures.add(itempicture);
            }

            menupinglunhuifu menupinglunhuifu =dao.findmenuonlypinglunhuifu(menupingluns.get(i).getId());

            if (menupinglunhuifu !=null){
                statuslist.add("已回");

            }else {
                statuslist.add("未回");
            }
        }
        request.setAttribute("menupingluns",menupingluns);
        request.setAttribute("menuplpictures",menuplpictures);
        request.setAttribute("statuslist",statuslist);
        request.getRequestDispatcher("st/smenupl/smenupl.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
