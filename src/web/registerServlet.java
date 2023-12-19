package web;


import dao.UserListDao;
import dao.impl.UserListDaoimpl;
import domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.support.ManagedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 * 用户注册
 */

@WebServlet("/registerServlet")
public class registerServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        int zhuangtai = 0;
        boolean mutipartContent = ServletFileUpload.isMultipartContent(request);

        if (!mutipartContent){

            request.setAttribute("errMsg","请选择头像");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            throw new RuntimeException("不是上传的类型");

        }

        //     上传的解析对象

        DiskFileItemFactory factory = new DiskFileItemFactory();


//     上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);

        //     解析上传文件名乱码

        upload.setHeaderEncoding("utf-8");

//     获取所有的请求
        List<String> userinforms = new ManagedList<>();

        try {
            List<FileItem> items = upload.parseRequest(request);

//            遍历
            for (FileItem item : items){

//                判断提交类型
//                普通类型
                if (item.isFormField()) {

                    String name = item.getFieldName();
                    System.out.println(name);
//                    防止用户名重复，通过全局变量是否采取插入

                    if (name.equals("username")){
                        String isusername = item.getString("utf-8");

                        UserListDao dao = new UserListDaoimpl();
                        User isuser= dao.findisuser(isusername);

                        if (isuser != null){
                            zhuangtai = 1;
                            break;
                        }else {
                            userinforms.add(isusername);
                        }

                    }else {
                        String string = item.getString("utf-8");
                        userinforms.add(string);
                    }



                }else {
//                    文件类型
//                 文件名字
                    System.out.println("扫到图片路径");

                    String filename = item.getName();
                    System.out.println("我的文件名字"+filename);
                    if (filename.length()==0){
                        request.setAttribute("errMsg","请选择头像");
                        request.getRequestDispatcher("register.jsp").forward(request,response);
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

                    String imgsrc = imgpath+timestamp +filename;

                    System.out.println("上传文件"+imgsrc);
                    userinforms.add(imgsrc);


                }


            }
            System.out.println(zhuangtai);

            if ( zhuangtai == 1){
                request.setAttribute("errMsg","已有此用户名");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }else {
                System.out.println("插入成功");
                System.out.println("插入用户名"+userinforms);
                UserListDao dao = new UserListDaoimpl();

                dao.addregisteruser(userinforms);

                response.getWriter().print("注册成功");

                response.sendRedirect("login.jsp");
            }




        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }










    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
