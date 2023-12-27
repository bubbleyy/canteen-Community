package web.admin.Apinglun.menu;

import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
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
 * 菜品评论信息修改
 */

@WebServlet("/AmenuplUpdateServlet")
public class AmenuplUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        MenuListDao dao = new MenuListDaoimpI();

        menupinglun menupinglun = dao.findonlymenupinglun(id);


          List<String> menupinglunpicture = JSONArray.fromObject(menupinglun.getPictures());
        request.setAttribute("menupinglun",menupinglun);
        request.setAttribute("menupinglunpicture",menupinglunpicture);
        request.getRequestDispatcher("admin/afoodpinglun/menu/amenuplupdate.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        boolean mutipartContent = ServletFileUpload.isMultipartContent(request);

        if (!mutipartContent){

            response.getWriter().print("系统错误，添加失败");
            throw new RuntimeException("不是上传的类型");

        }

        DiskFileItemFactory factory = new DiskFileItemFactory();


        ServletFileUpload upload = new ServletFileUpload(factory);


        upload.setHeaderEncoding("utf-8");


        menupinglun nowmenupinglun = new menupinglun();

        menupinglun menupinglun = new menupinglun();


        List<String> pictures = new ArrayList<>();

        try {
            List<FileItem> items = upload.parseRequest(request);

            for (FileItem item : items){

                if (item.isFormField()) {

                    String name = item.getFieldName();
                    String string = item.getString("utf-8");
                    System.out.println(name);
                    if (name.equals("id")){
                        MenuListDao dao = new MenuListDaoimpI();
                        nowmenupinglun = dao.findonlymenupinglun(string);
                        menupinglun.setId(Integer.parseInt(string));
                    }

                    else if (name.equals("pf")){

                        menupinglun.setPf(string);
                    }else if (name.equals("maintext")){
                        menupinglun.setMaintext(string);
                    }



                }else {

                    System.out.println("扫到图片路径");
//                    String filename = URLEncoder.encode(item.getName(), "UTF-8");
                    String filename = item.getName();
                    System.out.println("我的文件名字"+filename);
                    if (filename.length()==0 || filename.trim().equals("")){

                    }else {
                        String imgpath = "upload/";

                        String timestamp = Long.toString(System.currentTimeMillis());

                        String realPath =  this.getServletContext().getRealPath("/upload");

                        File file = new File(realPath);

                        if (!file.exists()){
                            file.mkdir();
                        }

                        item.write(new File(file,timestamp +filename));


                        String imgsrcshujuku = imgpath+timestamp +filename;

                        System.out.println("上传文件"+imgsrcshujuku);
                        pictures.add(imgsrcshujuku);
                    }



                }


            }

            System.out.println("修改图片上传"+pictures);
            if (pictures.size() == 0 ){
                System.out.println("我没上传图片");
                System.out.println(nowmenupinglun.getPictures());
                menupinglun.setPictures(nowmenupinglun.getPictures());
            }else {
                menupinglun.setPictures(JSONArray.fromObject(pictures).toString());
            }


            MenuListDao dao = new MenuListDaoimpI();

            dao.updatemenupinglun(menupinglun);

            response.getWriter().print("修改评论信息成功");

            response.sendRedirect("AmenuplServlet");






        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
