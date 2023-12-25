package web.admin;

import dao.StListDao;
import dao.impl.StListDaoimpI;
import domain.stgly;
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
import java.util.List;

/**
 * 食堂管理员信息修改
 */

@WebServlet("/AStGlRyUpdateServlet")
public class AStGlRyUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String stid = request.getParameter("stid");
        String username = request.getParameter("username");

        StListDao dao = new StListDaoimpI();

        stgly stgly = dao.findstglyusername(username);

        request.setAttribute("stid",stid);
        request.setAttribute("stgly",stgly);
        request.getRequestDispatcher("admin/people/astglyupdate.jsp").forward(request,response);

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


        stgly nowstgly = new stgly();
//     获取所有的请求
        stgly stgly = new stgly();


        try {
            List<FileItem> items = upload.parseRequest(request);

            for (FileItem item : items){

                if (item.isFormField()) {

                    String name = item.getFieldName();
                    String string = item.getString("utf-8");
                    System.out.println(name);
                    if (name.equals("stid")){
                        stgly.setSt_id(Integer.parseInt(string));
                    }

                    else if (name.equals("glyname")){

                        StListDao dao = new StListDaoimpI();

                         nowstgly = dao.findstglyusername(string);



                        stgly.setUsername(string);
                    }else if (name.equals("password")){
                        stgly.setPassword(string);
                    }



                }else {

//                 文件类型
//                 文件名字
                    System.out.println("扫到图片路径");
//                    String filename = URLEncoder.encode(item.getName(), "UTF-8");
                    String filename = item.getName();
                    System.out.println("我的文件名字"+filename);
                    if (filename.length()==0 || filename.trim().equals("")){
                        stgly.setFaceimg(nowstgly.getFaceimg());
                    }else {
                        String imgpath = "upload/";

                        String timestamp = Long.toString(System.currentTimeMillis());
//                    上传的位置
                        String realPath =  this.getServletContext().getRealPath("/upload");

//                    判断上传路径存不存在

                        File file = new File(realPath);

                        if (!file.exists()){
                            file.mkdir();
                        }

                        item.write(new File(file,timestamp +filename));


                        String imgsrcshujuku = imgpath+timestamp +filename;

                        System.out.println("上传文件"+imgsrcshujuku);
                        stgly.setFaceimg(imgsrcshujuku);
                    }



                }


            }



            stgly.setStatus(nowstgly.getStatus());

            StListDao dao = new StListDaoimpI();

            dao.updatestgly(stgly);

            response.getWriter().print("修改管理员成功");

            response.sendRedirect("AStGlRyServlet?stid="+stgly.getSt_id());






        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
