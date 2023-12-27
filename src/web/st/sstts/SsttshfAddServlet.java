package web.st.sstts;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.sttshf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 食堂投诉回复添加
 */

@WebServlet("/SsttshfAddServlet")
public class SsttshfAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

       String stts_id = request.getParameter("id");

       request.setAttribute("stts_id",stts_id);
       request.getRequestDispatcher("st/sstts/ssttshfadd.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
      String maintext =   request.getParameter("maintext");
        String stts_id =   request.getParameter("stts_id");

        sttshf sttshf = new sttshf();

        sttshf.setCreatetime();
        sttshf.setMaintext(maintext);
        sttshf.setStatus("未读");
        sttshf.setStts_id(Integer.parseInt(stts_id));
        sttshf.setFromwho("食堂");

        StListDao dao = new StListDaoimpI();

        dao.addsttshuifu(sttshf);
        response.sendRedirect("SsttsServlet");

    }
}
