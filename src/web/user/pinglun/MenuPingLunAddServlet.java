package web.user.pinglun;

import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
import domain.login.loginuser;
import domain.menupinglun;
import net.sf.json.JSONArray;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户菜品评论
 */

@WebServlet("/MenuPingLunAddServlet")
public class MenuPingLunAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");


        loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");

        boolean mutipartContent = ServletFileUpload.isMultipartContent(request);

        if (!mutipartContent){

            response.getWriter().print("系统错误，添加失败");
            throw new RuntimeException("不是上传的类型");

        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setHeaderEncoding("utf-8");

        menupinglun menupinglun = new menupinglun();

        List<String> pictures = new ArrayList<>();

        try {
            List<FileItem> items = upload.parseRequest(request);

            for (FileItem item : items){

                if (item.isFormField()) {

                    String name = item.getFieldName();
                    String string = item.getString("utf-8");
                    if (name.equals("id")){

                        menupinglun.setMenu_id(Integer.parseInt(string));
                    }else if (name.equals("maintext")){
                        menupinglun.setMaintext(string);
                    }else if (name.equals("pf")){
                        menupinglun.setPf(string);
                    }
                }else {


                    System.out.println("扫到图片路径");

                    String filename = item.getName();
                    System.out.println("我的文件名字"+filename);
                    if (filename.length()==0 || filename.trim().equals("")){

                        continue;
                    }

                    String imgpath = "upload/";

                    String timestamp = Long.toString(System.currentTimeMillis());

                    String realPath =  this.getServletContext().getRealPath("/upload");

                File file = new File(realPath);

                    if (!file.exists()){
                        file.mkdir();
                    }

                    item.write(new File(file,timestamp +filename));

                    String imgsrc = imgpath+timestamp +filename;

                    System.out.println("上传文件"+imgsrc);
                    pictures.add(imgsrc);

                }


            }

            menupinglun.setPictures(JSONArray.fromObject(pictures).toString());
            menupinglun.setCreatetime();
            menupinglun.setUser_username(loginuser.getUsername());

            MenuListDao dao = new MenuListDaoimpI();

            dao.addmenupinglun(menupinglun);

            response.getWriter().print("添加评论成功");

            response.sendRedirect("MenuDetailServlet?id="+ menupinglun.getMenu_id());


        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
