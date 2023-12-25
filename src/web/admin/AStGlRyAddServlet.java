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
 * 添加食堂管理员
 */

@WebServlet("/AStGlRyAddServlet")
public class AStGlRyAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String stid = request.getParameter("stid");

        request.setAttribute("stid",stid);
        request.getRequestDispatcher("admin/people/astglyadd.jsp").forward(request,response);

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

        //     上传的解析对象

        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setHeaderEncoding("utf-8");

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

                    else if (name.equals("username")){
                        System.out.println(name);
                        StListDao dao = new StListDaoimpI();

                        stgly stgly1 = dao.findstglyusername(string);

                        System.out.println("查询到用户名"+stgly1);
                        if (stgly1 !=null){
                            request.setAttribute("errMsg", "用户名已存在");
                            request.setAttribute("stid", stgly.getSt_id());
                            request.getRequestDispatcher("admin/people/astglyadd.jsp").forward(request, response);
                            return; // 终止后续操作
                        }

                        stgly.setUsername(string);
                    }else if (name.equals("password")){
                        stgly.setPassword(string);
                    }



                }else {

                    System.out.println("扫到图片路径");
//                    String filename = URLEncoder.encode(item.getName(), "UTF-8");
                    String filename = item.getName();
                    System.out.println("我的文件名字"+filename);
                    if (filename.length()==0 || filename.trim().equals("")){
                        request.setAttribute("errMsg","请选择图像");
                        request.getRequestDispatcher("admin/people/astglyadd.jsp").forward(request,response);
                        return;
                    }

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



            stgly.setStatus("正常");

            StListDao dao = new StListDaoimpI();

            dao.addstgly(stgly);

            response.getWriter().print("设置管理员成功");

            response.sendRedirect("AStGlRyServlet?stid="+stgly.getSt_id());






        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
