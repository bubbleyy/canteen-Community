package web.admin.Acommunity.Acommunitypinglun;

import dao.CommunityListDao;
import dao.impl.CommunityListDaoimpI;
import domain.communitypinglun;
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
 * 管理员端社区评论内容查找
 */

@WebServlet("/AcommunitypinglunsearchServlet")
public class AcommunitypinglunsearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

       String maintext =  request.getParameter("name");
        CommunityListDao dao = new CommunityListDaoimpI();
        List<communitypinglun> communitypingluns = dao.findcommunitypinglunlikemaintext(maintext);


        List<List<String>> pictures = new ArrayList<>();

        for (var i =0;i<communitypingluns.size() ;i++ ){
            if (communitypingluns.get(i).getPictures().length() != 0){
                List<String> itempicture =   JSONArray.fromObject(communitypingluns.get(i).getPictures());
                pictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                pictures.add(itempicture);
            }

        }

        System.out.println("图片"+pictures);
        request.setAttribute("communitypingluns",communitypingluns);
        request.setAttribute("pictures",pictures);

        request.getRequestDispatcher("admin/acommunity/apinglun/asqplxx.jsp").forward(request,response);
    }
}
