package web.st.smenupl;

import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
import domain.menupinglunhuifu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 回复菜品评论
 */

@WebServlet("/SmenuplhfAddServlet")
public class SmenuplhfAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

       String menupl_id = request.getParameter("id");

       request.setAttribute("menupl_id",menupl_id);
       request.getRequestDispatcher("st/smenupl/smenuplhfadd.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
      String maintext =   request.getParameter("maintext");
        String menupl_id =   request.getParameter("menupl_id");

        menupinglunhuifu menupinglunhuifu = new menupinglunhuifu();

        menupinglunhuifu.setCreatetime();
        menupinglunhuifu.setMaintext(maintext);
        menupinglunhuifu.setStatus("未读");
        menupinglunhuifu.setMenupl_id(Integer.parseInt(menupl_id));

        MenuListDao dao= new MenuListDaoimpI();

        dao.addmenupinglunhuifu(menupinglunhuifu);


        response.sendRedirect("SmenuplServlet");

    }
}
