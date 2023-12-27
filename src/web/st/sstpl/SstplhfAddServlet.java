package web.st.sstpl;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.stpinglunhuifu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 食堂评论回复
 */

@WebServlet("/SstplhfAddServlet")
public class SstplhfAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

       String stpl_id = request.getParameter("id");

       request.setAttribute("stpl_id",stpl_id);
       request.getRequestDispatcher("st/sstpl/sstplhfadd.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
      String maintext =   request.getParameter("maintext");
        String stpl_id =   request.getParameter("stpl_id");

        stpinglunhuifu stpinglunhuifu = new stpinglunhuifu();

        stpinglunhuifu.setCreatetime();
        stpinglunhuifu.setMaintext(maintext);
        stpinglunhuifu.setStatus("未读");
        stpinglunhuifu.setStpl_id(Integer.parseInt(stpl_id));

        StListDao dao = new StListDaoimpI();

        dao.addstpinglunhuifu(stpinglunhuifu);
        response.sendRedirect("SstplServlet");

    }
}
