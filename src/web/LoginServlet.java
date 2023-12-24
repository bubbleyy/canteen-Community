package web;


import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import domain.User;
import domain.admin;
import domain.login.loginadmin;
import domain.login.loginstgly;
import domain.login.loginuser;
import domain.stgly;
import netscape.javascript.JSObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 登录操作
 */


@WebServlet("/loginServlet")
public class LoginServlet<User> extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String username= request.getParameter("username");
        String password = request.getParameter("password");
        String logintype = request.getParameter("logintype");
        System.out.println("我的账号"+username);
        System.out.println("我的密码"+password);
        System.out.println("登录状态"+logintype);

        UserListDao dao = new UserListDaoimpl();

        if (logintype.equals("师生用户")){

            domain.User user  =  dao.findssyh(username,password);

            System.out.println("查询结果"+user);
            if (user == null){

                System.out.println("登录失败");
                request.setAttribute("error","用户名或密码错误!");
                request.getRequestDispatcher("login.jsp").forward(request,response);


            }else {

                if (user.getStatus().equals("异常")){
                    request.setAttribute("error","账户异常，请联系管理员");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else {
                    System.out.println("登录成功");
                    loginuser loginuser = new loginuser();
                    loginuser.setUsername(user.getUsername()) ;
                    loginuser.setFaceimg(user.getFaceimg());
                    loginuser.setLogintype(logintype);
                    loginuser.setStatus("正常");

                    request.getSession().setAttribute("loginuser",loginuser);
                    request.getSession().setAttribute("logintype",logintype);
                    response.sendRedirect("IndexServlet");
                }


            }

        }else if (logintype.equals("食堂管理员")){

            stgly user = dao.findstgly(username,password);
            System.out.println("查询结果"+user);
            if (user == null){

                System.out.println("登录失败");
                request.setAttribute("error","用户名或密码错误!");
                request.getRequestDispatcher("login.jsp").forward(request,response);


            }else {

                if (user.getStatus().equals("异常")){
                    request.setAttribute("error","账户异常，请联系管理员");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else {
                    System.out.println("登录成功");
                    loginstgly loginuser = new loginstgly();
                    loginuser.setUsername(user.getUsername()) ;
                    loginuser.setFaceimg(user.getFaceimg());
                    loginuser.setLogintype(logintype);
                    loginuser.setSt_id(user.getSt_id());
                    loginuser.setStatus("正常");

                    request.getSession().setAttribute("loginuser",loginuser);

                    request.getSession().setAttribute("logintype",logintype);
                    response.sendRedirect("SIndexServlet");
                }


            }
        }else {
            admin user = dao.findadmin(username,password);
            System.out.println("查询结果"+user);
            if (user == null){

                System.out.println("登录失败");
                request.setAttribute("error","用户名或密码错误!");
                request.getRequestDispatcher("login.jsp").forward(request,response);


            }else {

                System.out.println("登录成功");
                loginadmin loginuser = new loginadmin();
                loginuser.setUsername(user.getUsername()) ;
                loginuser.setFaceimg(user.getFaceimg());
                loginuser.setLogintype(logintype);

                request.getSession().setAttribute("loginuser",loginuser);

                request.getSession().setAttribute("logintype",logintype);
                response.sendRedirect("AIndexServlet");



            }
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
