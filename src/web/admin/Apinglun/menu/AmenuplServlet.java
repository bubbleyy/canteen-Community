package web.admin.Apinglun.menu;


import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
import domain.menupinglun;
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
 * 系统端菜品评论著列表
 */


@WebServlet("/AmenuplServlet")
public class AmenuplServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");



        MenuListDao dao = new MenuListDaoimpI();

        List<menupinglun>  menupingluns = dao.findallmenupinglun();

               List<List<String>> menuplpictures = new ArrayList<>();

        for (int i =0;i<menupingluns.size() ;i++ ){
            if (menupingluns.get(i).getPictures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(menupingluns.get(i).getPictures());
                menuplpictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                menuplpictures.add(itempicture);
            }

        }
        request.setAttribute("menupingluns",menupingluns);
        request.setAttribute("menuplpictures",menuplpictures);
        request.getRequestDispatcher("admin/afoodpinglun/menu/amenupl.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
