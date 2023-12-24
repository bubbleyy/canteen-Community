package web.admin;

import dao.StListDao;
import dao.impl.StListDaoimpI;
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

/**
 * 食堂管理主列表
 */

@WebServlet("/AStGlServlet")
public class AStGlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        StListDao dao = new StListDaoimpI();
        List<st> sts = dao.findallst();

        System.out.println("食堂列表"+sts);

        List<List<String>> pictures = new ArrayList<>();

        for (var i =0;i<sts.size() ;i++ ){
            if (sts.get(i).getPictures().length() != 0){
                List<String> itempicture =   JSONArray.fromObject(sts.get(i).getPictures());
                pictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                pictures.add(itempicture);
            }

        }

        System.out.println("图片"+pictures);
       request.setAttribute("sts",sts);
        request.setAttribute("pictures",pictures);
       request.getRequestDispatcher("admin/people/astgl.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

       String stname =  request.getParameter("name");

        StListDao dao = new StListDaoimpI();
        List<st> sts = dao.findshitangname(stname);

        List<List<String>> pictures = new ArrayList<>();

        for (var i =0;i<sts.size() ;i++ ){
            if (sts.get(i).getPictures().length() != 0){
                List<String> itempicture =   JSONArray.fromObject(sts.get(i).getPictures());
                pictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                pictures.add(itempicture);
            }

        }
        request.setAttribute("sts",sts);
        request.setAttribute("pictures",pictures);
        request.getRequestDispatcher("admin/people/astgl.jsp").forward(request,response);
    }
}
