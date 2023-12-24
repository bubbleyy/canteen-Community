package web.admin;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.st;
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
 * 添加食堂
 */

@WebServlet("/AStGlAddServlet")
public class AStGlAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        st st = new st();

        List<String> pictures = new ArrayList<>();

        try {
            List<FileItem> items = upload.parseRequest(request);

            for (FileItem item : items){

                if (item.isFormField()) {

                    String name = item.getFieldName();
                    String string = item.getString("utf-8");
                    if (name.equals("name")){

                        st.setName(string);
                    }else if (name.equals("position")){
                        st.setPosition(string);
                    }else if (name.equals("introduce")){
                        st.setIntroduce(string);
                    }else if (name.equals("yysj")){
                        st.setYysj(string);
                    }

                }else {

                    System.out.println("扫到图片路径");

                    String filename = item.getName();
                    System.out.println("我的文件名字"+filename);
                    if (filename.length()==0 || filename.trim().equals("")){
                        request.setAttribute("errMsg","请选择图像");
                        request.getRequestDispatcher("register.jsp").forward(request,response);
                        return;
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


            st.setPictures(JSONArray.fromObject(pictures).toString());
            st.setCreatetime();
            st.setLooknumber(1);

            StListDao dao = new StListDaoimpI();

            dao.addst(st);

            response.getWriter().print("添加食堂成功");

            response.sendRedirect("AStGlServlet");




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
