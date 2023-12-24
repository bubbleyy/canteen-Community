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
 * 食堂信息修改
 */

@WebServlet("/AStGlUpdateServlet")
public class AStGlUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String stid = request.getParameter("stid");

        StListDao dao = new StListDaoimpI();

        st st = dao.findonlyst(stid);


          List<String> stpicture = JSONArray.fromObject(st.getPictures());
        System.out.println("食堂图片"+stpicture);
        request.setAttribute("st",st);
        request.setAttribute("stpicture",stpicture);
        request.getRequestDispatcher("admin/people/astupdate.jsp").forward(request,response);

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


        st nowst = new st();

        st st = new st();


        List<String> pictures = new ArrayList<>();

        try {
            List<FileItem> items = upload.parseRequest(request);

            for (FileItem item : items){


                if (item.isFormField()) {

                    String name = item.getFieldName();
                    String string = item.getString("utf-8");
                    System.out.println(name);
                    if (name.equals("id")){
                        StListDao dao = new StListDaoimpI();
                        nowst = dao.findonlyst(string);
                        st.setId(Integer.parseInt(string));
                    }

                    else if (name.equals("name")){

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
                System.out.println(nowst.getPictures());
                st.setPictures(nowst.getPictures());
            }else {
                st.setPictures(JSONArray.fromObject(pictures).toString());
            }

            st.setLooknumber(nowst.getLooknumber());



            StListDao dao = new StListDaoimpI();

            dao.updatest(st);

            response.getWriter().print("修改食堂成功");

            response.sendRedirect("AStGlServlet");


        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
