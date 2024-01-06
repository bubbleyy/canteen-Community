package web.st.smenu;


import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
import domain.login.loginstgly;
import domain.menu;
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
 * 菜品主列表
 */


@WebServlet("/SMenuServlet")
public class SMenuServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        loginstgly loginstgly = (domain.login.loginstgly) request.getSession().getAttribute("loginuser");


        MenuListDao dao = new MenuListDaoimpI();
       List<menu>  menus = dao.findstallcp(loginstgly.getSt_id());


               List<List<String>> menupictures = new ArrayList<>();

        for (int i =0;i<menus.size() ;i++ ){
            if (menus.get(i).getPictures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(menus.get(i).getPictures());
                menupictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                menupictures.add(itempicture);
            }

        }
        request.setAttribute("menus",menus);
        request.setAttribute("menupictures",menupictures);
        request.getRequestDispatcher("st/smenu/smenu.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        loginstgly loginstgly = (domain.login.loginstgly) request.getSession().getAttribute("loginuser");


        MenuListDao dao = new MenuListDaoimpI();
        List<menu>  menus = dao.findstpclike(loginstgly.getSt_id(),name);
        List<List<String>> menupictures = new ArrayList<>();
        for (int i =0;i<menus.size() ;i++ ){
            if (menus.get(i).getPictures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(menus.get(i).getPictures());
                menupictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                menupictures.add(itempicture);
            }

        }
        request.setAttribute("menus",menus);

        request.setAttribute("menupictures",menupictures);
        request.getRequestDispatcher("st/smenu/smenu.jsp").forward(request,response);

    }
}
