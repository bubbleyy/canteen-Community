package web.st.smenu;

import dao.MenuListDao;
import dao.impl.MenuListDaoimpI;
import domain.menu;
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
 * 食堂菜品修改
 */

@WebServlet("/SMenuUpdateServlet")
public class SMenuUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        MenuListDao dao = new MenuListDaoimpI();

        menu menu = dao.findonlymenu(id);


          List<String> stmenupictures = JSONArray.fromObject(menu.getPictures());
        request.setAttribute("menu",menu);
        request.setAttribute("stmenupictures",stmenupictures);
        request.getRequestDispatcher("st/smenu/smenuupdate.jsp").forward(request,response);

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


        menu nowmenu = new menu();
//     获取所有的请求
        menu menu = new menu();


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
                        nowmenu = dao.findonlymenu(string);
                        menu.setId(Integer.parseInt(string));
                    }

                    else if (name.equals("name")){

                        menu.setName(string);
                    }else if (name.equals("tw")){
                       menu.setTw(string);
                    }else if (name.equals("money")){
                        menu.setMoney(string);
                    }else if (name.equals("type")){
                        menu.setType(string);
                    }else if (name.equals("cuxiao")){
                        menu.setCuxiao(string);
                    }else if (name.equals("introduce")){
                        menu.setIntroduce(string);
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
//                    上传的位置
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
                menu.setPictures(nowmenu.getPictures());
            }else {
                menu.setPictures(JSONArray.fromObject(pictures).toString());
            }

            MenuListDao dao = new MenuListDaoimpI();

            dao.updatestmenu(menu);

            response.getWriter().print("修改菜品成功");

            response.sendRedirect("SMenuServlet");


        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
