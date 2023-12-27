package web.admin.Apinglun.st;


import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.stpinglun;
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
 * 系统端食堂评论著列表
 */


@WebServlet("/AstplServlet")
public class AstplServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");



        StListDao dao = new StListDaoimpI();

        List<stpinglun>  stpingluns = dao.findallstpinglun();

               List<List<String>> stplpictures = new ArrayList<>();

        for (var i =0;i<stpingluns.size() ;i++ ){
            if (stpingluns.get(i).getPritures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(stpingluns.get(i).getPritures());
                stplpictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                stplpictures.add(itempicture);
            }

        }
        request.setAttribute("stpingluns",stpingluns);
        request.setAttribute("stplpictures",stplpictures);
        request.getRequestDispatcher("admin/afoodpinglun/st/astpl.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
