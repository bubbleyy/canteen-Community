package web.st.sinform;


import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import domain.inform;
import domain.login.loginstgly;
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
 * 食堂端公告主列表
 */


@WebServlet("/SInformServlet")
public class SInformServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        loginstgly loginstgly = (domain.login.loginstgly) request.getSession().getAttribute("loginuser");


        UserListDao dao = new UserListDaoimpl();
       List<inform>  gonggaos = dao.findstgg(String.valueOf(loginstgly.getSt_id()));


               List<List<String>> gonggaopicture = new ArrayList<>();

        for (int i =0;i<gonggaos.size() ;i++ ){
            if (gonggaos.get(i).getPictures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(gonggaos.get(i).getPictures());
                gonggaopicture.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                gonggaopicture.add(itempicture);
            }

        }
        System.out.println("公告列表"+gonggaos);
        request.setAttribute("gonggaos",gonggaos);
        request.setAttribute("gonggaopictures",gonggaopicture);
        request.getRequestDispatcher("st/sinform/sinform.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");

        UserListDao dao = new UserListDaoimpl();
        List<inform>  gonggaos = dao.findggsearch(name);
        List<List<String>> gonggaopicture = new ArrayList<>();
        for (int i =0;i<gonggaos.size() ;i++ ){
            if (gonggaos.get(i).getPictures() !=null ){
                List<String> itempicture =   JSONArray.fromObject(gonggaos.get(i).getPictures());
                gonggaopicture.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                gonggaopicture.add(itempicture);
            }

        }
        request.setAttribute("gonggaos",gonggaos);

        request.setAttribute("gonggaopictures",gonggaopicture);
        request.getRequestDispatcher("st/sinform/sinform.jsp").forward(request,response);

    }
}
