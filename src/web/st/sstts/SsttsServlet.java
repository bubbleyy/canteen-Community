package web.st.sstts;


import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.login.loginstgly;
import domain.stts;
import domain.sttshf;
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
 * 食堂投诉著列表
 */


@WebServlet("/SsttsServlet")
public class SsttsServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        loginstgly loginstgly = (domain.login.loginstgly) request.getSession().getAttribute("loginuser");


        StListDao dao = new StListDaoimpI();
       List<stts>  sttss = dao.findsttsinstgly(String.valueOf(loginstgly.getSt_id()));


               List<List<String>> sttspictures = new ArrayList<>();
               List<String> statuslist = new ArrayList<>();

        for (var i =0;i<sttss.size() ;i++ ){
            if (sttss.get(i).getPictures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(sttss.get(i).getPictures());
                sttspictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                sttspictures.add(itempicture);
            }

            sttshf sttshf =dao.findonlysttshf(sttss.get(i).getId());

            if (sttshf !=null){
                statuslist.add("已回");

            }else {
                statuslist.add("未回");
            }
        }
        request.setAttribute("sttss",sttss);
        request.setAttribute("sttspictures",sttspictures);
        request.setAttribute("statuslist",statuslist);
        request.getRequestDispatcher("st/sstts/sstts.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
