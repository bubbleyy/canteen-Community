package web.user.standmenu;

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
 * 用户里食堂列表
 */

@WebServlet("/StServlet")
public class StServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StListDao dao = new StListDaoimpI();

        List<st> sts = dao.findallst();
        List<List<String>> stpictures = new ArrayList<>();

        for (var i =0;i<sts.size() ;i++ ){
            if (sts.get(i).getPictures().length() != 0){
                List<String> itempicture =   JSONArray.fromObject(sts.get(i).getPictures());
                stpictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                stpictures.add(itempicture);
            }

        }



        request.setAttribute("sts",sts);
        request.setAttribute("stpictures",stpictures);
        request.getRequestDispatcher("user/st.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
