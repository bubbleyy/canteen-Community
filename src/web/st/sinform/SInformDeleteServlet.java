package web.st.sinform;

import dao.StListDao;
import dao.impl.StListDaoimpI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除公告
 */

@WebServlet("/SInformDeleteServlet")
public class SInformDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        StListDao dao = new StListDaoimpI();
       dao.deletestinform(id);


       response.sendRedirect("SInformServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
