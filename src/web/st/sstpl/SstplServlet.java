package web.st.sstpl;


import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.login.loginstgly;
import domain.stpinglun;
import domain.stpinglunhuifu;
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
 * 食堂评论著列表
 */


@WebServlet("/SstplServlet")
public class SstplServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        loginstgly loginstgly = (domain.login.loginstgly) request.getSession().getAttribute("loginuser");


        StListDao dao = new StListDaoimpI();
       List<stpinglun>  stpingluns = dao.findstpinglun(String.valueOf(loginstgly.getSt_id()));


               List<List<String>> stplpictures = new ArrayList<>();
               List<String> statuslist = new ArrayList<>();

        for (var i =0;i<stpingluns.size() ;i++ ){
            if (stpingluns.get(i).getPritures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(stpingluns.get(i).getPritures());
                stplpictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                stplpictures.add(itempicture);
            }

            stpinglunhuifu stpinglunhuifu =dao.findonlystpinglunhuifu(stpingluns.get(i).getId());

            if (stpinglunhuifu !=null){
                statuslist.add("已回");

            }else {
                statuslist.add("未回");
            }
        }
        request.setAttribute("stpingluns",stpingluns);
        request.setAttribute("stplpictures",stplpictures);
        request.setAttribute("statuslist",statuslist);
        request.getRequestDispatcher("st/sstpl/sstpl.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
