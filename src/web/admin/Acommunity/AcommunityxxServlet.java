package web.admin.Acommunity;

import dao.CommunityListDao;
import dao.impl.CommunityListDaoimpI;
import domain.community;
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
 * 社区信息主列表
 */

@WebServlet("/AcommunityxxServlet")
public class AcommunityxxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        CommunityListDao dao = new CommunityListDaoimpI();
        List<community> communities = dao.findallcommunities();


        List<List<String>> pictures = new ArrayList<>();

        for (int i =0;i<communities.size() ;i++ ){
            if (communities.get(i).getPictures().length() != 0){
                List<String> itempicture =   JSONArray.fromObject(communities.get(i).getPictures());
                pictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                pictures.add(itempicture);
            }

        }

        System.out.println("图片"+pictures);
       request.setAttribute("communities",communities);
        request.setAttribute("pictures",pictures);
       request.getRequestDispatcher("admin/acommunity/asqxx.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
