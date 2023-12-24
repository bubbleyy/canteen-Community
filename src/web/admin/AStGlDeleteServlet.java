package web.admin;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.stgly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 删除食堂
 */

@WebServlet("/AStGlDeleteServlet")
public class AStGlDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        StListDao dao = new StListDaoimpI();
       dao.deletest(id);


        List<stgly>  stglies = dao.findstrygl(id);

        if (stglies.size() >0){
            for (var i =0;i<stglies.size();i++){
                dao.deletestgly(stglies.get(i).getUsername());
            }
        }


       response.sendRedirect("AStGlServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
