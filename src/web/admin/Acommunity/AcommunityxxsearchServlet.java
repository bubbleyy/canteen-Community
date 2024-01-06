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
 * 社区信息搜索
 */

@WebServlet("/AcommunityxxsearchServlet")
public class AcommunityxxsearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

       String title =  request.getParameter("name");

        CommunityListDao dao = new CommunityListDaoimpI();
        List<community> communities = dao.findcommunitytitlelike(title);

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
        request.setAttribute("communities",communities);
        request.setAttribute("pictures",pictures);
        request.getRequestDispatcher("admin/acommunity/asqxx.jsp").forward(request,response);
    }
}
